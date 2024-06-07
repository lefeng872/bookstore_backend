package com.example.bookstore_backend.utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;

import java.util.Map;

@Component
public class CustomInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Request URL: " + request.getRequestURL());
        // todo 可以在这里进行身份验证、日志记录等操作
        System.out.println("Request Session ID");
        System.out.println(request.getRequestedSessionId());
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("Request intercepted");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false; // 中断请求
        } else {
            System.out.println("Request pass interceptor");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 在请求处理之后、视图渲染之前执行的逻辑
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // 在请求处理完毕后执行的逻辑
    }
}
