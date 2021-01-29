package com.bili.scoreboard.server.impl;

import com.bili.scoreboard.dao.GameInfo;
import com.bili.scoreboard.dao.Gamer;
import com.bili.scoreboard.pojo.MatchingInfoDTO;
import com.bili.scoreboard.server.GamerService;
import com.bili.scoreboard.server.MatchingService;
import com.bili.scoreboard.util.PreOperation;
import com.bili.scoreboard.util.RedisUtil;
import com.bili.scoreboard.util.TimeToId.IdGeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 　　* @description: TODO
 * 　　* @throws
 * 　　* @author oxx
 * 　　* @date 2021/1/20 17:46
 */
@Slf4j
@Service("matchingService")
public class MatchingServiceImpl implements MatchingService {

    private static final Long ONE_DAY = 86400L;
    private static final Integer GAMER_NUMBER =4;
    @Autowired
    PreOperation preOperation;

    @Autowired
    GamerService gamerService;


    @Override
    public Boolean matchingWith(MatchingInfoDTO dto) {
        //唯一用户标识
        final String userInfo = dto.getUserInfo();
        //用户输入的房间号
        final String inputNum = dto.getInputNum();
        //如果存在这个房间，就加入
        if (preOperation.hasThisRoom(inputNum)) {
            final GameInfo gameInfo = preOperation.getRoomInfo(inputNum);
            List<Gamer> gamers = gameInfo.getGamers();
            //小于四个就可以添加
            if (gamers.size()<GAMER_NUMBER) {
                final Gamer gamer = new Gamer(userInfo, 25000.0,
                        false,preOperation.getRoomInfo(inputNum).getGamers().size());
                gamers.add(gamer);
                gameInfo.setGamers(gamers);
                //保存信息
                preOperation.intoGameRoom(inputNum,gameInfo);
                return true;
            } else {
                //页面跳转，这里使用消息队列通知其他用户，暂时return false
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String createRoom(MatchingInfoDTO dto) {
        //前端的唯一用户表示
        final String userInfo = dto.getUserInfo();
        //游戏状态，是东风还是半庄
        final Integer gameState = dto.getGameState();
        final GameInfo gameInfo = new GameInfo();
        //创建房间，生成唯一房间号，1天过期
        String roomNum;
        do {
            roomNum = IdGeneratorUtil.generateSequenceNo();
            log.info("创建房间号为："+roomNum);
        } while (preOperation.hasThisRoom(roomNum));
        preOperation.createRoomInMap(roomNum);
        log.info("创建房间号为："+roomNum);
        //把用户信息插入
        //按进房顺序排座位,默认房主为0
        final Gamer gamer = new Gamer(userInfo, 25000.0, false, 0);
        gameInfo.setRoomId(roomNum);
        gameInfo.setGameState(gameState);
        //把玩家放入list中
        List<Gamer> gamerList = new ArrayList<>(4);
        gamerList.add(gamer);
        gameInfo.setGamers(gamerList);
        //玩家加入房间
        preOperation.intoGameRoom(roomNum,gameInfo);
        //返回房间号
        return roomNum;
    }
}
