package com.bili.scoreboard.util;

import com.bili.scoreboard.dao.GameInfo;
import com.bili.scoreboard.dao.Gamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @title: Operation
 * @projectName scoreboard
 * @description: TODO
 * @date 2021/1/2620:12
 */
@Component
public class PreOperation {
    private static final long ONE_DAY = 86400L;
    @Autowired
    RedisUtil redisUtil;

    public GameInfo getRoomInfo(String roomId){
        return (GameInfo) redisUtil.get(roomId+ ":game");
    }

    public void intoGameRoom(String roomId, GameInfo gameInfo){
        redisUtil.set(roomId + ":game", gameInfo, ONE_DAY);
    }

    public boolean hasThisRoom(String roomId){
        return redisUtil.hHasKey("roomId", roomId);
    }

    public void createRoomInMap(String roomId){
        redisUtil.hset("roomId", roomId, ONE_DAY);
    }
}
