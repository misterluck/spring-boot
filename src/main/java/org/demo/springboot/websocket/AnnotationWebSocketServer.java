/*
package org.demo.springboot.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value = "/websocket/{username}")
@Component
public class AnnotationWebSocketServer {

    private Session session;
    private static Map<String, Session> sessionPool = new HashMap<String, Session>();
    private static Map<String, String> sessionIds = new HashMap<String, String>();

    @OnOpen
    public void open(Session session, @PathParam(value = "username") String username) {
        this.session = session;
        sessionPool.put(username, session);
        sessionIds.put(session.getId(), username);
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("当前发送人的sessionId为："+session.getId()+"发送内容为："+message);
    }

    @OnClose
    public void onClose() {
        sessionPool.remove(sessionIds.get(session.getId()));
        sessionIds.remove(session.getId());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public static void sendMessage(String message, String username) {
        Session session = sessionPool.get(username);
        if (session != null) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getOnlineNum() {
        return sessionPool.size();
    }

    public static String getOnlineUsers() {
        return sessionIds.values().toString();
    }

    public static void sendAll(String message) {
        for (String username:sessionIds.keySet()) {
            sendMessage(message, sessionIds.get(username));
        }
    }

}
*/
