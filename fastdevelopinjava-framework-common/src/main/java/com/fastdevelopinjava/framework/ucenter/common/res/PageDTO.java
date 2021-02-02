package com.fastdevelopinjava.framework.ucenter.common.res;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class PageDTO<T> implements Serializable {
    private Long total;
    private List<T> list;


    public PageDTO() {
    }

    public PageDTO(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }
}
