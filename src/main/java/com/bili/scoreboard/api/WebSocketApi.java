package com.bili.scoreboard.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @title: WebSocketApi
 * @projectName scoreboard
 * @description: TODO
 * @date 2021/1/288:41
 */
@CrossOrigin
@Api(tags = "使用websocket发送信息",value = "v1/getMassage")
@RequestMapping(value = "v1/getMassage")
public interface WebSocketApi {
    /**
     * 群体发送信息
     * @return
     */
    @GetMapping("/sendAllWebSocket")
    public String sendAll();

    /**
     * 单点发送信息，不过应该用不到
     * @param userName
     * @return
     */
    @GetMapping("/sendOneWebSocket/{userName}")
    public String sendOneWebSocket(@PathVariable("userName") String userName) ;
}
