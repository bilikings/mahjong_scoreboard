package com.bili.scoreboard.util;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author admin
 * @title: WebSocket
 * @projectName scoreboard
 * @description: TODO
 * @date 2021/1/288:27
 */
@Component
@ServerEndpoint("/websocket/{userName}")
public class WebSocket {
    private Session session;

    private static CopyOnWriteArrayList<WebSocket> webSockets = new CopyOnWriteArrayList<>();
    private static Map<String ,Session> sessionPool = new HashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam(value="userName")String userName) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(userName, session);
        System.out.println(userName+"【websocket消息】有新的连接，总数为:"+webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }

    /**
     * 此为广播消息
     * @param message
     */
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 此为单点消息
     * @param userName
     * @param message
     */
    public void sendOneMessage(String userName, String message) {
        System.out.println("【websocket消息】单点消息:"+message);
        Session session = sessionPool.get(userName);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
