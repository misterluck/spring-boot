package org.demo.springboot.websocket;

import org.demo.springboot.bean.ClientMessage;
import org.demo.springboot.bean.SendToUserMessage;
import org.demo.springboot.bean.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping(value = "/welcome")
    @SendTo("/topic/getResponse")
    public ClientMessage sendClient(ServerMessage serverMessage) {
        return new ClientMessage(serverMessage.getMessage());
    }

    @MessageMapping(value = "/chat")
    public void chatUser(Principal principal, SendToUserMessage sendToUserMessage) {
        System.out.println(sendToUserMessage.getUsername());
        System.out.println(sendToUserMessage.getMessage());
        simpMessagingTemplate.convertAndSendToUser(principal.getName(), "/queue/notifications", "测试发送消息!");
    }

}
