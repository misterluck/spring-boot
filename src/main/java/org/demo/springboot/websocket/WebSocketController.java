package org.demo.springboot.websocket;

import org.demo.springboot.bean.ClientMessage;
import org.demo.springboot.bean.ServerMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping(value = "/welcome")
    @SendTo("/topic/getResponse")
    public ClientMessage sendClient(ServerMessage serverMessage) {
        return new ClientMessage(serverMessage.getMessage());
    }

}
