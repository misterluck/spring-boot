package org.demo.springboot.bootstrap;

import org.demo.springboot.bean.StompPrincipal;
import org.demo.springboot.util.CustomHandshakeHandler;
import org.demo.springboot.util.CustomSessionAuthHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.session.ExpiringSession;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.session.web.socket.server.SessionRepositoryMessageInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.springframework.web.socket.sockjs.transport.handler.WebSocketTransportHandler;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;

/**
 * 配置WebSocket协议的stomp协议
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractSessionWebSocketMessageBrokerConfigurer<ExpiringSession> {

    /**
     * 该类继承AbstractWebSocketMessageBrokerConfigurer时注册websocket端点
     */
    /*@Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/stompWebSocket").withSockJS();
    }*/

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 该类继承AbstractSessionWebSocketMessageBrokerConfigurer时注册websocket端点
     */
    @Override
    protected void configureStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointBroadcast").withSockJS();
        stompEndpointRegistry.addEndpoint("/endpointChat")
                .addInterceptors(new CustomSessionAuthHandshakeInterceptor())
                .setHandshakeHandler(new CustomHandshakeHandler())
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue");
    }
}
