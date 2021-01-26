package com.bili.scoreboard;

import com.bili.scoreboard.dao.GameInfo;
import com.bili.scoreboard.dao.Gamer;
import com.bili.scoreboard.util.PreOperation;
import com.bili.scoreboard.util.RedisUtil;
import com.bili.scoreboard.util.TimeToId.IdGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class ScoreboardApplicationTests {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    PreOperation preOperation;
    @Test
    void contextLoads() {
    }

    @Test
    void demo1(){
        final GameInfo roomInfo = preOperation.getRoomInfo("330061");
        final List<Gamer> gamers = roomInfo.getGamers();
        for(Gamer g:gamers){
            System.out.println(g.getInfo());
        }
    }

}
