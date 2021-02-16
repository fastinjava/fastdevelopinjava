package com.fastinjava.service.gateway.base;

import com.fastinjava.service.gateway.web.filters.pre.AssembleFilter;

public enum GatewayFilter {

    ASSEMBLE_FILTER("ASSEMBLE_FILTER", "组装请求参数过滤器", AssembleFilter.class, "组装请求参数过滤器错误");

    private String name;
    private String desc;
    private Class<?> clazz;
    private String errorMessage;

    GatewayFilter(String name, String desc, Class<?> clazz, String errorMessage) {
        this.name = name;
        this.desc = desc;
        this.clazz = clazz;
        this.errorMessage = errorMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
