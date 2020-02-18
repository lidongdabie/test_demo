package com.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 16:05
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createNewTaskData {

    /**
     * areaId : 310114
     * areaName : 嘉定区
     * authId : 350526197805232849
     * cityId : 310100
     * cityName : 上海市
     * createOperId : 259
     * createOperName : 姜杏环球
     * hasRelatedSubTask : false
     * inspectorCreate : false
     * orderSeq : C2019080916270000041
     * place : 嘉定安亭镇
     * priority : 0
     * problemTypeId : 12
     * processRole : customServant
     * processRoleName : 客服
     * processUserName : 姜杏环球
     * provinceId : 310000
     * provinceName : 上海市
     * realUserName : 姜测试
     * remark : 测试及任务
     * shopName : 安驰路绿地
     * shopSeq : 1516
     * taskDetail : {"IS_IN_SPECIFIED_SHOP":"1","IS_VEHICLE_ABNORMAL":"1","noDeductiblesFlag":"0","ORDER_RUN_TIME":"329150","IS_NEED_ALLOCATION":"1","VEHICLE_TERMINAL_ID":"DE260042"}
     * taskLocation : 上海市上海市嘉定区嘉定安亭镇
     * userName : 姜测试
     * userPhone : 15039291618
     * userRole : customServant
     * vehicleModelInfo : 荣威E50
     * vehicleModelSeq : 2
     * vehicleNo : 沪AD54321
     * vin : B2BCESHI018
     */

    private int areaId;
    private String areaName;
    private String authId;
    private int cityId;
    private String cityName;
    private int createOperId;
    private String createOperName;
    private boolean hasRelatedSubTask;
    private boolean inspectorCreate;
    private String orderSeq;
    private String place;
    private int priority;
    private int problemTypeId;
    private String processRole;
    private String processRoleName;
    private String processUserName;
    private int provinceId;
    private String provinceName;
    private String realUserName;
    private String remark;
    private String shopName;
    private int shopSeq;
    private TaskDetailBean taskDetail;
    private String taskLocation;
    private String userName;
    private String userPhone;
    private String userRole;
    private String vehicleModelInfo;
    private int vehicleModelSeq;
    private String vehicleNo;
    private String vin;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TaskDetailBean {
        /**
         * IS_IN_SPECIFIED_SHOP : 1
         * IS_VEHICLE_ABNORMAL : 1
         * noDeductiblesFlag : 0
         * ORDER_RUN_TIME : 329150
         * IS_NEED_ALLOCATION : 1
         * VEHICLE_TERMINAL_ID : DE260042
         */

        private String IS_IN_SPECIFIED_SHOP;
        private String IS_VEHICLE_ABNORMAL;
        private String noDeductiblesFlag;
        private String ORDER_RUN_TIME;
        private String IS_NEED_ALLOCATION;
        private String VEHICLE_TERMINAL_ID;
    }
}
