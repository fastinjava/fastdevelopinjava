package com.fastdevelopinjava.service.user.convert;

import cn.hutool.core.bean.BeanUtil;

public interface Convert {

    default void copyProperties(Object source,Object target){
        BeanUtil.copyProperties(source,target);
    }
}
