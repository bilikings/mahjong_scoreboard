package com.bili.scoreboard.dao;

import lombok.Data;

/**
 * @author admin
 * @title: MultipleType
 * @projectName scoreboard
 * @description: 番数的实体类
 * @date 2021/1/2720:05
 */
@Data
public class MultipleType {
    /**
     * 立直
     */
    private Integer liZhi;
    /**
     * 平和
     */
    private Integer pinHe;

    /**
     * 断幺九
     */
    private Integer duanYaoJiu;
    /**
     * 役牌
     */
    private Integer yiPai;
    /**
     * 门清
     */
    private Integer menQing;
    /**
     * 对对
     */
    private Integer duiDui;
    /**
     * 七对子
     */
    private Integer qiDui;
    /**
     * 清一色
     */
    private Integer qingYiSe;
    /**
     *
     * 其他一番
     */
    private Integer otherOne;
    /**
     * 其他两番
     */
    private Integer otherTwo;
    /**
     * 宝牌
     */
    private Integer dora;
}
