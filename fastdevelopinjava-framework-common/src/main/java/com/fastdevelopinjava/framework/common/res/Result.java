package com.fastdevelopinjava.framework.common.res;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class Result<T> implements Serializable {
    private String success;
    private String code;
    private String msg;
    private T data;
}
