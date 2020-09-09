package com.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcelDataVO {
    /**
     * 号牌号码
     */
    private String hphm;

    /**
     * 罚款金额
     */
    private String fkje;

    /**
     * 记分值
     */
    private String wfjfs;

    /**
     * 违法时间
     */
    private String wfsj;

    /**
     * 违法行为
     */
    private String wfms;

    /**
     * 违法地点
     */
    private String wfdz;

    /**
     * 是否处理
     */
    private String clbjStr;

    /**
     * 缴款状态
     */
    private String jkbjStr;

    /**
     * 号牌种类
     */
    private String hpzlStr;

}
