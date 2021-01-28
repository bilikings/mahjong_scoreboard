package com.bili.scoreboard.util;

import com.bili.scoreboard.dao.Gamer;
import com.bili.scoreboard.dao.MultipleType;
import com.bili.scoreboard.pojo.GetPointDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @title: PointHelpUtil
 * @projectName scoreboard
 * @description: 为了算分之类的
 * @date 2021/1/2720:19
 */
public class PointHelpUtil {
    private final static double BANKER = 1.5;
    /**
     * 获取分数
     * @param getPointDTO
     * @return List<Double>[获取方式（自摸,从别家）,分数]
     */
    public static List<Double> calculationPoint(GetPointDTO getPointDTO) {
        List<Double> res;

        //从哪家得分
        final Double state = getPointDTO.getState();
        //如果输入分数为空就使用快捷番数计算,先搁置，只用
        if (getPointDTO.getInputScore() == null) {
            final MultipleType multipleType = getPointDTO.getMultipleType();

        }
        res = Arrays.asList(state, getPointDTO.getInputScore());
        return res;
    }
 /**
 　　* @description: 自摸
 　　* @param null:
 　　* @return ${return_type}
 　　* @throws
 　　* @author oxx
 　　* @date 2021/1/27 20:58
 　　*/
    public Double getPoint(GetPointDTO getPointDTO, Gamer gamer){
        final List<Double> stateAndPoint = calculationPoint(getPointDTO);
        //如果是自摸
        if(stateAndPoint.get(0)==0){
            if(gamer.getIsBanker()){
                //通知加入消息队列 inputMQ()

                return stateAndPoint.get(1)*BANKER;
            }else {
                //通知加入消息队列 inputMQ()

                return stateAndPoint.get(1);
            }
        }else if(stateAndPoint.get(0)==1) {
            //通知加入消息队列 inputMQ()
            return stateAndPoint.get(1);
        }
        return 0.0;
    }

    private static Double calculationMultiplePoint(MultipleType m){
        double allMult = m.getDora()+
                m.getDuanYaoJiu()+
                m.getLiZhi()+
                m.getMenQing()+
                m.getYiPai()+
                m.getPinHe()+
                m.getOtherOne()+
                m.getQingYiSe()+
                m.getQiDui();

        return allMult;
    }
}
