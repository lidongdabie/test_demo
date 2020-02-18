package com.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 20:53
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class queryMyTaskData {

    /**
     * vehicleNo :
     * vehicleModelSeqList : []
     * problemTypeId :
     * processRoleList : []
     * priority :
     * minCreateTime : 2019-05-23 00:00:00
     * maxCreateTime : 2019-08-21 00:00:00
     * regionId :
     * orgId :
     * createRole :
     * createOperName :
     * externalTask : false
     * delayTask : false
     * dispatchTaskSeq : WFHC201908200010
     * authority : 1
     * pageSize : 20
     * pageNum : 1
     * queryLastPage : false
     * queryTotal : false
     */
    private String vehicleNo;
    private String problemTypeId;
    private String priority;
    private String minCreateTime;
    private String maxCreateTime;
    private String regionId;
    private String orgId;
    private String createRole;
    private String createOperName;
    private boolean externalTask;
    private boolean delayTask;
    private String dispatchTaskSeq;
    private int authority;
    private int pageSize;
    private int pageNum;
    private boolean queryLastPage;
    private boolean queryTotal;
    private List<?> vehicleModelSeqList;
    private List<?> processRoleList;
}
