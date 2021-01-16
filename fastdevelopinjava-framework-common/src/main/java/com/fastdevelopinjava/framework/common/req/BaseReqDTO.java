package com.fastdevelopinjava.framework.common.req;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class BaseReqDTO implements Serializable {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Boolean enablePage = true;
}
