package org.demo.springboot.bootstrap;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.*;

/**
 * 配置WebSocket协议的stomp协议
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 该类继承AbstractWebSocketMessageBrokerConfigurer时注册websocket端点
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/stompWebSocket").withSockJS();
    }

    /**
     * 该类继承AbstractSessionWebSocketMessageBrokerConfigurer时注册websocket端点
     */
    /*@Override
    protected void configureStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/stompWebSocket").withSockJS();
    }*/

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
