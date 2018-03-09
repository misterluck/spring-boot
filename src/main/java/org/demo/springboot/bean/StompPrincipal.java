package org.demo.springboot.bean;

import java.security.Principal;

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
