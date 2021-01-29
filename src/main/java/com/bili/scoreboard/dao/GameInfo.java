package com.bili.scoreboard.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author admin
 * @title: GameInfo
 * @projectName scoreboard
 * @description: TODO
 * @date 2021/1/2615:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfo {
    private String roomId;

    List<Gamer> gamers;

    /**
     *  是第几局了，东一东二之类的
     */
    private Integer gameState;

    /**
     *  公有点棒
     */
    private Double publicScore;

    /**
     *  本场数
     */
    private Integer gameStateTimes;

    private Long version;
}
