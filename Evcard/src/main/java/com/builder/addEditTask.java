package com.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jinwei on 2019/8/19.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class addEditTask {
    private String id;
    private String orgId;
    private String taskOrgId;
}
