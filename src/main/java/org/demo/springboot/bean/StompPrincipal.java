package org.demo.springboot.bean;

import java.security.Principal;

/**
 * 自定义标记WebSocket连接的username
 * 提供给CustomHandshakeHandler
 */
public class StompPrincipal implements Principal {

    private String username;

    public StompPrincipal(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return this.username;
    }
}
