package org.demo.springboot.util;

import org.demo.springboot.bean.StompPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        //System.out.println("***************"+attributes.get("SPRING.SESSION.ID"));
        //String token = (String) attributes.get("token");
        String token = UUID.randomUUID().toString();
        System.out.println("***************"+token);
        return new StompPrincipal(token);
    }

}
