package com.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 13:15
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class dispatchData {

    /**
     * procInstId : 15405045
     * permissionValue : assign
     * id : 20096
     * taskDetail : {"regionId":320586}
     */

    private String procInstId;
    private String permissionValue;
    private int id;
    private String reportReason;
    private TaskDetailBean taskDetail;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TaskDetailBean {
        /**
         * regionId : 320586
         */
        private int regionId;
        private String authId;

    }

}
