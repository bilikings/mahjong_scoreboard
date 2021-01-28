package com.bili.scoreboard.pojo;

import com.bili.scoreboard.dao.MultipleType;
import lombok.Data;

/**
 * @author admin
 * @title: getPointDTO
 * @projectName scoreboard
 * @description: TODO
 * @date 2021/1/2720:15
 */
@Data
public class GetPointDTO {
    /**
     * 快捷番数
     */
    private MultipleType multipleType;

    /**
     * 输入的分数
     */
    private Double inputScore;

    /**
     * 从哪家拿分还是自摸,
     * 0: 自摸
     * 1: 从上家
     * 2: 从对家
     * 3: 从下家
     */
    private Double state;
}
