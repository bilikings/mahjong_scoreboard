package com.bili.scoreboard.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 * @title: Gamer
 * @projectName scoreboard
 * @description: TODO
 * @date 2021/1/2615:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gamer {

    private String info;

    private Integer point;

    private Boolean isBanker;

    private Integer seat;

}
