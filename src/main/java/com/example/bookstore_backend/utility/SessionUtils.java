package com.example.bookstore_backend.utility;

import com.example.bookstore_backend.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {
    public static void setSession(User user) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            HttpSession session = request.getSession();
            System.out.println("Session created with ID: " + session.getId());
        } else {
            System.out.println("Failed to get ServletRequestAttributes");
        }
    }
    public static void removeSession() {
        HttpSession session = getSession();
        if (session != null) {
            session.invalidate();
        }
    }
    private static HttpSession getSession() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            return request.getSession(false);
        }
        return null;
    }
}
