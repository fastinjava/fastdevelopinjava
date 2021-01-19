package com.fastdevelopinjava.framework.common.res;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class PageResultDTO<T> implements Serializable {
    private Long total;
    private List<T> list;

    public PageResultDTO(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }
}
