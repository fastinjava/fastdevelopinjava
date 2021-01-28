package com.fastdevelopinjava.framework.common.res;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class ResultDTO<T> implements Serializable {
    private Boolean success;
    private String code;
    private String msg;
    private T data;




    public ResultDTO() {
    }


    public static <T> ResultDTO<T> success(T data) {
        ResultDTO<T> tResultDTO = new ResultDTO<>();
        tResultDTO.setSuccess(true);
        tResultDTO.setCode(CommonResultCode.SUCCESS.getCode());
        tResultDTO.setMsg(CommonResultCode.SUCCESS.getMsg());
        tResultDTO.setData(data);
        return tResultDTO;
    }


    public static <T> ResultDTO<T> failure(String msg) {
        ResultDTO<T> tResultDTO = new ResultDTO<>();
        tResultDTO.setSuccess(false);
        tResultDTO.setCode(CommonResultCode.FAILURE.getCode());
        tResultDTO.setMsg(msg);
        return tResultDTO;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
