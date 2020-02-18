package com.builder;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 15:28
 * @Description:
 */
@Data
@Builder
public class evworkUploadTaskInfo {

    /**
     * contentMap : {"PIC_URL":"","DEAL_RESULT":"234684488464884648464666"}
     * dispatchTaskId : 20217
     * token : XXXXXX
     */

    private ContentMapBean contentMap;
    private int dispatchTaskId;
    private String token;
    private BaseMap baseMap;

    @Data
    @Builder
    public static class ContentMapBean {
        /**
         * PIC_URL :
         * DEAL_RESULT :
         */

        @JSONField(name = "PIC_URL")
        private String PIC_URL;
        @JSONField(name = "DEAL_RESULT")
        private String DEAL_RESULT;
        @JSONField(name = "IS_ILLEGAL")
        private String IS_ILLEGAL;
        @JSONField(name = "ILLEGAL_DEAL_RESULT")
        private String ILLEGAL_DEAL_RESULT;
        @JSONField(name = "ILLEGAL_PIC_URL")
        private String ILLEGAL_PIC_URL;
        @JSONField(name = "RESTRICTIVE_ROAD_FEE")
        private String RESTRICTIVE_ROAD_FEE;
        @JSONField(name = "NO_RESTRICTIVE_ROAD_FEE")
        private String NO_RESTRICTIVE_ROAD_FEE;
        @JSONField(name = "PARK_FEE")
        private String PARK_FEE;
        @JSONField(name = "TRAIL_CAR_PIC_URL")
        private String TRAIL_CAR_PIC_URL;
    }

    @Data
    @Builder
    public static class BaseMap {
        @JSONField(name = "IS_ILLEGAL")
        private String IS_ILLEGAL;
    }
}
