package org.demo.springboot.util;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

public class CustomSessionAuthHandshakeInterceptor implements HandshakeInterceptor {

    public static final String HTTP_SESSION_ID_ATTR_NAME = "HTTP.SESSION.ID";
    public static final String SPRING_SESSION_ID_ATTR_NAME = "SPRING.SESSION.ID";

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        /*if (serverHttpRequest instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)serverHttpRequest;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                String uuid = UUID.randomUUID().toString();
                System.out.println("***************"+uuid);
                attributes.put("token", uuid);
            }
        }*/
        if (attributes.containsKey(HTTP_SESSION_ID_ATTR_NAME)) {
            attributes.put(SPRING_SESSION_ID_ATTR_NAME, attributes.get(HTTP_SESSION_ID_ATTR_NAME));
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
