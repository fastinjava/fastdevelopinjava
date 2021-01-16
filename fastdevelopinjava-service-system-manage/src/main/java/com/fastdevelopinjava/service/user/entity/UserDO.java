package com.fastdevelopinjava.service.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author lify
 * @since 2021-01-16
 */
@Builder
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("u_user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 删除标识
     */
    private Integer deleteFlag;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 创建用户主键id
     */
    private Integer createdUserId;

    /**
     * 更新用户主键id
     */
    private Integer updatedUserId;
    /**
     * 创建时间
     */
    private Date createdTime;

}
