package com.fastdevelopinjava.service.user.client;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.api.system.manage.client.UserClient;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.framework.common.res.ResResultDTO;
import com.fastdevelopinjava.service.user.convert.UserConvert;
import com.fastdevelopinjava.service.user.mapper.UserMapper;
import com.fastdevelopinjava.service.user.service.UserService;
import jdk.management.resource.ResourceRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * 入参校验
 * 出参封装
 */
@Slf4j
@Service
public class UserClientImpl implements UserClient {

    @Resource
    private UserService userService;

    @Override
    public ResResultDTO<PageResultDTO<UserDTO>> selectList(UserReqDTO userReqDTO) {
        ResResultDTO<PageResultDTO<UserDTO>> resResultDTO = new ResResultDTO<>();
        try {
            PageResultDTO<UserDTO> pageResultDTO = userService.selectList(userReqDTO);
            resResultDTO.setSuccess(true);
            resResultDTO.setData(pageResultDTO);
        } catch (Exception e) {
            resResultDTO.setSuccess(false);
            resResultDTO.setErrorMessage(e.getMessage());
            log.error("UserClientImpl#selectList error , userReqDTO = {} ", userReqDTO);
        }
        return resResultDTO;
    }

    @Override
    public ResResultDTO<UserDTO> selectByPrimaryKey(Integer userId) {
        ResResultDTO<UserDTO> resResultDTO = new ResResultDTO<>();
        try {
            UserDTO userDTO = userService.selectByPrimaryKey(userId);
            resResultDTO.setSuccess(true);
            resResultDTO.setData(userDTO);
        } catch (Exception e) {
            resResultDTO.setSuccess(false);
            resResultDTO.setErrorMessage(e.getMessage());
        }
        return resResultDTO;
    }

    @Override
    public ResResultDTO<Boolean> deleteByPrimaryKey(Integer userId) {
        ResResultDTO<Boolean> resResultDTO = ResResultDTO.<Boolean>builder().build();
        try {
            Boolean result = userService.deleteByPrimaryKey(userId);
            if (result) {
                resResultDTO.setSuccess(true);
                resResultDTO.setData(true);
            } else {
                resResultDTO.setSuccess(false);
                resResultDTO.setErrorMessage("删除失败");
            }
        } catch (Exception e) {
            resResultDTO.setSuccess(false);
            resResultDTO.setErrorMessage(e.getMessage());
        }
        return resResultDTO;
    }

    @Override
    public ResResultDTO<Boolean> insert() {
        return null;
    }

    @Override
    public ResResultDTO<Boolean> insertOrUpdate() {
        return null;
    }

    @Override
    public ResResultDTO<Boolean> insertOrUpdateSelective() {
        return null;
    }

    @Override
    public ResResultDTO<Boolean> insertSelective(UserCreateDTO userCreateDTO) {
        ResResultDTO<Boolean> resResultDTO = ResResultDTO.<Boolean>builder().build();
        try {
            Boolean result = userService.insertSelective(userCreateDTO);
            if (result) {
                resResultDTO.setSuccess(true);
                resResultDTO.setData(true);
            } else {
                resResultDTO.setSuccess(false);
                resResultDTO.setErrorMessage("新增失败");
            }
        } catch (Exception e) {
            resResultDTO.setSuccess(false);
            resResultDTO.setErrorMessage(e.getMessage());
        }
        return resResultDTO;
    }

    @Override
    public ResResultDTO<Boolean> updateByPrimaryKeySelective(UserUpdateDTO userUpdateDTO) {
        ResResultDTO<Boolean> resResultDTO = ResResultDTO.<Boolean>builder().build();
        try {
            if (ObjectUtil.isEmpty(userUpdateDTO.getUserId())) {
                resResultDTO.setSuccess(false);
                resResultDTO.setErrorMessage("userId不能为空");
                return resResultDTO;
            }
            Boolean result = userService.updateByPrimaryKeySelective(userUpdateDTO);
            if (result) {
                resResultDTO.setSuccess(true);
                resResultDTO.setData(true);
            } else {
                resResultDTO.setSuccess(false);
                resResultDTO.setErrorMessage("更新失败");
            }
        } catch (Exception e) {
            resResultDTO.setSuccess(false);
            resResultDTO.setErrorMessage(e.getMessage());
        }
        return resResultDTO;
    }

    @Override
    public ResResultDTO<Boolean> updateByPrimaryKey() {
        return null;
    }

    @Override
    public ResResultDTO<Boolean> updateBatch() {
        return null;
    }

    @Override
    public ResResultDTO<Boolean> updateBatchSelective() {
        return null;
    }

    @Override
    public ResResultDTO<Boolean> batchInsert() {
        return null;
    }
}
