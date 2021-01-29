package com.fastdevelopinjava.framework.ucenter.common.res;

public enum CommonResultCode implements ResultCode {

    SUCCESS(Boolean.TRUE, "00000", "操作成功"),
    FAILURE(Boolean.FALSE, "-1", "操作失败"),
    ;


    private Boolean success;
    private String code;
    private String msg;


    CommonResultCode(Boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }


    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
