package com.bili.scoreboard.controller;

import com.bili.scoreboard.api.WebSocketApi;
import com.bili.scoreboard.util.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admin
 * @title: WebSocketController
 * @projectName scoreboard
 * @description: TODO
 * @date 2021/1/288:47
 */
public class WebSocketController implements WebSocketApi {

    @Autowired
    WebSocket webSocket;
    @Override
    public String sendAll() {
        {
            String text="你们好！这是websocket群体发送！";
            webSocket.sendAllMessage(text);
            return text;
        }
    }

    @Override
    public String sendOneWebSocket(String userName) {
        String text=userName+" 你好！ 这是websocket单人发送！";
        webSocket.sendOneMessage(userName,text);
        return text;
    }
}
