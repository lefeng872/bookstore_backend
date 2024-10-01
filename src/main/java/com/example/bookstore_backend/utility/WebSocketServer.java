package com.example.bookstore_backend.utility;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/websocket/{userID}")
@Component
public class WebSocketServer {
    private static final AtomicInteger onlineCount = new AtomicInteger(0);
    private static final ConcurrentHashMap<Integer, Session> sessions = new ConcurrentHashMap<>();

    public WebSocketServer() {
        System.out.println("WebSocketServer constructor");
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userID") String userID) {
        System.out.println("onOpen");
        if (sessions.get(Integer.parseInt(userID)) != null) {
            System.out.println("User already connected");
            return;
        }
        sessions.put(Integer.parseInt(userID), session);
        onlineCount.incrementAndGet();
        System.out.println("onlineCount: " + onlineCount.get());
        System.out.println(userID + " connected");
    }

    @OnClose
    public void onClose(Session session, @PathParam("userID") String userID) {
        sessions.remove(Integer.parseInt(userID));
        onlineCount.decrementAndGet();
        System.out.println("onlineCount: " + onlineCount.get());
        System.out.println(userID + " disconnected");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("onMessage: " + message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("onError: " + throwable.getMessage());
    }

    public void sendMessage(Session toSession, String message) {
        if (toSession != null) {
            try {
                toSession.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("user is not connected");
        }
    }

    public void sendMessageToUser(Integer userID, String message) {
        Session toSession = sessions.get(userID);
        sendMessage(toSession, message);
        System.out.println("sendMessageToUser: " + message);
    }
}
