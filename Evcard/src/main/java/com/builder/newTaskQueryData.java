package com.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 09:45
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class newTaskQueryData {

    /**
     * createType : 3
     * type : 12
     * authId : 14001140171025403076
     * orderSeq : C2019082007380000011
     */

    private int createType;
    private int type;
    private String authId;
    private String orderSeq;
}
