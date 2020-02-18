package com.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 21:24
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class queryMyTaskResultData {

    /**
     * code : 0
     * data : {"page":{"pageNum":1,"pageSize":20,"startRow":0,"endRow":20,"total":-1,"pages":1},"list":[{"id":20319,"dispatchTaskSeq":"WFHC201908200010","problemTypeId":12,"problemTypeName":"无法还车","regionId":"320586","provinceId":310000,"cityId":310100,"areaId":310114,"place":"嘉定安亭镇","authId":"15821565217095835415","userName":"姜**","userPhone":"150****1618","realUserName":"姜**","memberAuthId":"350526197805232849","isViolate":null,"autoAssignRegionId":null,"autoAssignRegionName":null,"vehicleSystemType":1,"priority":0,"orderSeq":"C2019080916270000041","remark":"测试及任务","dispatchTaskStatus":0,"shopSeq":1516,"shopName":"安驰路绿地","vin":"B2BCESHI018","miscDesc":null,"status":1,"createTime":"2019-08-20 20:48:48","createOperId":259,"createOperName":"姜杏环球","updateTime":"2019-08-20 21:10:33","updateOperId":259,"updateOperName":"姜杏环球","createRole":"customServant","userOrigin":null,"vehicleNo":"沪AD54321","endTime":null,"vehicleModelInfo":"荣威E50","vehicleModelInfoList":null,"vehicleModelSeqList":null,"reportTime":"2019-08-20 21:10:33","reportReason":"let拖","assignUser":"车城区域","taskLocation":"上海市上海市嘉定区嘉定安亭镇","procInstId":"15715143","dispatchTaskId":20319,"activitiProcinstId":"15715143","authority":1,"userRole":"320586","taskDefKey":"areaManagerHandle","editPermission":"0","permissions":[{"name":"指派","value":"assign","assignRole":"inspector","controller":"","params":[{"needFlag":"1","name":"authId","type":"Long"}],"factoryFlag":null,"needParams":[{"needFlag":"1","name":"authId","type":"Long"}]},{"name":"上报","value":"reject","assignRole":"dispatch","controller":"","params":[],"factoryFlag":null,"needParams":[]}],"cityName":"上海市","provinceName":"上海市","areaName":"嘉定区","bathPermission":"1","taskAssignTime":"2019-08-20 20:50:03","taskCancelTime":null,"memberName":"林云霞","regionName":"车城区域","relatedTaskSeq":null,"onlineShopName":null,"startTime":null,"noRestrictiveRoadFee":0,"restrictiveRoadFee":0,"parkFee":0,"orgId":"000T","inspectorHandleResult":"let拖","actualAllotmentShopName":null,"actualAllotmentRegion":null,"actualAllotmentArea":null,"inspectorCallTime":null,"cleanTimeUpperLimit":0,"cleanTimeLowerLimit":0,"cleanCount":0,"taskEndTime":null,"cleaningCount":0,"cleanedCount":0}]}
     */

    private String code;
    private DataBean data;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataBean {
        /**
         * page : {"pageNum":1,"pageSize":20,"startRow":0,"endRow":20,"total":-1,"pages":1}
         * list : [{"id":20319,"dispatchTaskSeq":"WFHC201908200010","problemTypeId":12,"problemTypeName":"无法还车","regionId":"320586","provinceId":310000,"cityId":310100,"areaId":310114,"place":"嘉定安亭镇","authId":"15821565217095835415","userName":"姜**","userPhone":"150****1618","realUserName":"姜**","memberAuthId":"350526197805232849","isViolate":null,"autoAssignRegionId":null,"autoAssignRegionName":null,"vehicleSystemType":1,"priority":0,"orderSeq":"C2019080916270000041","remark":"测试及任务","dispatchTaskStatus":0,"shopSeq":1516,"shopName":"安驰路绿地","vin":"B2BCESHI018","miscDesc":null,"status":1,"createTime":"2019-08-20 20:48:48","createOperId":259,"createOperName":"姜杏环球","updateTime":"2019-08-20 21:10:33","updateOperId":259,"updateOperName":"姜杏环球","createRole":"customServant","userOrigin":null,"vehicleNo":"沪AD54321","endTime":null,"vehicleModelInfo":"荣威E50","vehicleModelInfoList":null,"vehicleModelSeqList":null,"reportTime":"2019-08-20 21:10:33","reportReason":"let拖","assignUser":"车城区域","taskLocation":"上海市上海市嘉定区嘉定安亭镇","procInstId":"15715143","dispatchTaskId":20319,"activitiProcinstId":"15715143","authority":1,"userRole":"320586","taskDefKey":"areaManagerHandle","editPermission":"0","permissions":[{"name":"指派","value":"assign","assignRole":"inspector","controller":"","params":[{"needFlag":"1","name":"authId","type":"Long"}],"factoryFlag":null,"needParams":[{"needFlag":"1","name":"authId","type":"Long"}]},{"name":"上报","value":"reject","assignRole":"dispatch","controller":"","params":[],"factoryFlag":null,"needParams":[]}],"cityName":"上海市","provinceName":"上海市","areaName":"嘉定区","bathPermission":"1","taskAssignTime":"2019-08-20 20:50:03","taskCancelTime":null,"memberName":"林云霞","regionName":"车城区域","relatedTaskSeq":null,"onlineShopName":null,"startTime":null,"noRestrictiveRoadFee":0,"restrictiveRoadFee":0,"parkFee":0,"orgId":"000T","inspectorHandleResult":"let拖","actualAllotmentShopName":null,"actualAllotmentRegion":null,"actualAllotmentArea":null,"inspectorCallTime":null,"cleanTimeUpperLimit":0,"cleanTimeLowerLimit":0,"cleanCount":0,"taskEndTime":null,"cleaningCount":0,"cleanedCount":0}]
         */

        private PageBean page;
        private List<PageBean.ListBean> list;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class PageBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * startRow : 0
             * endRow : 20
             * total : -1
             * pages : 1
             */

            private int pageNum;
            private int pageSize;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;


            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ListBean {
                /**
                 * id : 20319
                 * dispatchTaskSeq : WFHC201908200010
                 * problemTypeId : 12
                 * problemTypeName : 无法还车
                 * regionId : 320586
                 * provinceId : 310000
                 * cityId : 310100
                 * areaId : 310114
                 * place : 嘉定安亭镇
                 * authId : 15821565217095835415
                 * userName : 姜**
                 * userPhone : 150****1618
                 * realUserName : 姜**
                 * memberAuthId : 350526197805232849
                 * isViolate : null
                 * autoAssignRegionId : null
                 * autoAssignRegionName : null
                 * vehicleSystemType : 1
                 * priority : 0
                 * orderSeq : C2019080916270000041
                 * remark : 测试及任务
                 * dispatchTaskStatus : 0
                 * shopSeq : 1516
                 * shopName : 安驰路绿地
                 * vin : B2BCESHI018
                 * miscDesc : null
                 * status : 1
                 * createTime : 2019-08-20 20:48:48
                 * createOperId : 259
                 * createOperName : 姜杏环球
                 * updateTime : 2019-08-20 21:10:33
                 * updateOperId : 259
                 * updateOperName : 姜杏环球
                 * createRole : customServant
                 * userOrigin : null
                 * vehicleNo : 沪AD54321
                 * endTime : null
                 * vehicleModelInfo : 荣威E50
                 * vehicleModelInfoList : null
                 * vehicleModelSeqList : null
                 * reportTime : 2019-08-20 21:10:33
                 * reportReason : let拖
                 * assignUser : 车城区域
                 * taskLocation : 上海市上海市嘉定区嘉定安亭镇
                 * procInstId : 15715143
                 * dispatchTaskId : 20319
                 * activitiProcinstId : 15715143
                 * authority : 1
                 * userRole : 320586
                 * taskDefKey : areaManagerHandle
                 * editPermission : 0
                 * permissions : [{"name":"指派","value":"assign","assignRole":"inspector","controller":"","params":[{"needFlag":"1","name":"authId","type":"Long"}],"factoryFlag":null,"needParams":[{"needFlag":"1","name":"authId","type":"Long"}]},{"name":"上报","value":"reject","assignRole":"dispatch","controller":"","params":[],"factoryFlag":null,"needParams":[]}]
                 * cityName : 上海市
                 * provinceName : 上海市
                 * areaName : 嘉定区
                 * bathPermission : 1
                 * taskAssignTime : 2019-08-20 20:50:03
                 * taskCancelTime : null
                 * memberName : 林云霞
                 * regionName : 车城区域
                 * relatedTaskSeq : null
                 * onlineShopName : null
                 * startTime : null
                 * noRestrictiveRoadFee : 0
                 * restrictiveRoadFee : 0
                 * parkFee : 0
                 * orgId : 000T
                 * inspectorHandleResult : let拖
                 * actualAllotmentShopName : null
                 * actualAllotmentRegion : null
                 * actualAllotmentArea : null
                 * inspectorCallTime : null
                 * cleanTimeUpperLimit : 0
                 * cleanTimeLowerLimit : 0
                 * cleanCount : 0
                 * taskEndTime : null
                 * cleaningCount : 0
                 * cleanedCount : 0
                 */

                private int id;
                private String dispatchTaskSeq;
                private int problemTypeId;
                private String problemTypeName;
                private String regionId;
                private int provinceId;
                private int cityId;
                private int areaId;
                private String place;
                private String authId;
                private String userName;
                private String userPhone;
                private String realUserName;
                private String memberAuthId;
                private Object isViolate;
                private Object autoAssignRegionId;
                private Object autoAssignRegionName;
                private int vehicleSystemType;
                private int priority;
                private String orderSeq;
                private String remark;
                private int dispatchTaskStatus;
                private int shopSeq;
                private String shopName;
                private String vin;
                private Object miscDesc;
                private int status;
                private String createTime;
                private int createOperId;
                private String createOperName;
                private String updateTime;
                private int updateOperId;
                private String updateOperName;
                private String createRole;
                private Object userOrigin;
                private String vehicleNo;
                private Object endTime;
                private String vehicleModelInfo;
                private Object vehicleModelInfoList;
                private Object vehicleModelSeqList;
                private String reportTime;
                private String reportReason;
                private String assignUser;
                private String taskLocation;
                private String procInstId;
                private int dispatchTaskId;
                private String activitiProcinstId;
                private int authority;
                private String userRole;
                private String taskDefKey;
                private String editPermission;
                private String cityName;
                private String provinceName;
                private String areaName;
                private String bathPermission;
                private String taskAssignTime;
                private Object taskCancelTime;
                private String memberName;
                private String regionName;
                private Object relatedTaskSeq;
                private Object onlineShopName;
                private Object startTime;
                private int noRestrictiveRoadFee;
                private int restrictiveRoadFee;
                private int parkFee;
                private String orgId;
                private String inspectorHandleResult;
                private Object actualAllotmentShopName;
                private Object actualAllotmentRegion;
                private Object actualAllotmentArea;
                private Object inspectorCallTime;
                private int cleanTimeUpperLimit;
                private int cleanTimeLowerLimit;
                private int cleanCount;
                private Object taskEndTime;
                private int cleaningCount;
                private int cleanedCount;
                private List<PermissionsBean> permissions;


                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static class PermissionsBean {
                    /**
                     * name : 指派
                     * value : assign
                     * assignRole : inspector
                     * controller :
                     * params : [{"needFlag":"1","name":"authId","type":"Long"}]
                     * factoryFlag : null
                     * needParams : [{"needFlag":"1","name":"authId","type":"Long"}]
                     */

                    private String name;
                    private String value;
                    private String assignRole;
                    private String controller;
                    private Object factoryFlag;
                    private List<ParamsBean> params;
                    private List<NeedParamsBean> needParams;

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ParamsBean {
                        /**
                         * needFlag : 1
                         * name : authId
                         * type : Long
                         */

                        private String needFlag;
                        private String name;
                        private String type;
                    }

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class NeedParamsBean {
                        /**
                         * needFlag : 1
                         * name : authId
                         * type : Long
                         */

                        private String needFlag;
                        private String name;
                        private String type;
                    }
                }
            }
        }
    }
}
