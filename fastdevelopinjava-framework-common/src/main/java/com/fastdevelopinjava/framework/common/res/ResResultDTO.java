package com.fastdevelopinjava.framework.common.res;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class ResResultDTO<T> implements Serializable {
    private Boolean success;
    private String errorMessage;
    private T data;
}
