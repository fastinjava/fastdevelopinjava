package com.fastdevelopinjava.framework.ucenter.api.dto;

import com.fastdevelopinjava.framework.common.condition.FieldNotNull;
import com.fastdevelopinjava.framework.common.condition.ParamCheck;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ParamCheck(value = true)
public class RoleUpdateDTO
        implements Serializable {
    /**
     * 角色id
     */
    @FieldNotNull
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 是否删除
     */
    private String deleteFlag;

    private Date creatTime;

    private Date updateTime;


    interface Update {
    }

}
