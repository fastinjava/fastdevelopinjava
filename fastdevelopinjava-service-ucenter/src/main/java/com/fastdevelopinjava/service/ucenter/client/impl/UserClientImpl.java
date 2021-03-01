package com.fastdevelopinjava.service.ucenter.client.impl;

import com.fastdevelopinjava.framework.ucenter.api.client.UserClient;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.ResultDTO;
import com.fastdevelopinjava.service.ucenter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "用户管理",tags = {"用户管理api"})
@Slf4j
@RestController
@RequestMapping("/user")
public class UserClientImpl implements UserClient {
    @Resource
    private UserService userService;

    @ApiOperation("用户详情")
    @Override
    @PostMapping("/getOne")
    public ResultDTO<UserDTO> selectOne(@RequestBody UserReqDTO userReqDTO) {
        ResultDTO<UserDTO> result = new ResultDTO<>();
        try {
            UserDTO userDTO = userService.getOne(userReqDTO);
            result.setSuccess(true);
            result.setData(userDTO);
            log.info("userDTO = {} ", userDTO);
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.UserClientImpl.getOne error , {} ", e.getMessage());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @ApiOperation("用户列表")
    @Override
    @PostMapping("/selectList")
    public ResultDTO<PageDTO<UserDTO>> selectList(@RequestBody UserReqDTO userReqDTO) {
        ResultDTO<PageDTO<UserDTO>> result = new ResultDTO<>();
        try {
            PageDTO<UserDTO> pageDTO = userService.getList(userReqDTO);
            result.setSuccess(true);
            result.setData(pageDTO);
        } catch (Exception e) {
            log.error("\ncom.fastdevelopinjava.service.ucenter.client.impl.UserClientImpl.selectList\n userReqDTO = {} \n  error = {} ", userReqDTO, e.getMessage());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @ApiOperation("用户新增")
    @Override
    @PostMapping("/insert")
    public ResultDTO<Boolean> insert(@RequestBody UserCreateDTO userCreateDTO) {
        ResultDTO<Boolean> resultDTO = new ResultDTO<>();
        try {
            resultDTO.setSuccess(true);
            resultDTO.setData(userService.insert(userCreateDTO));
        } catch (Exception e) {
            log.error("\ncom.fastdevelopinjava.service.ucenter.client.impl.UserClientImpl.selectList\n userCreateDTO = {} \n  error = {} ", userCreateDTO, e.getMessage());
            resultDTO.setSuccess(false);
            resultDTO.setMsg(e.getMessage());
        }
        return resultDTO;
    }

    @ApiOperation("用户更新")
    @Override
    @PostMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody UserUpdateDTO userUpdateDTO) {
        ResultDTO<Boolean> resultDTO = new ResultDTO<>();
        try {
            resultDTO.setSuccess(true);
            resultDTO.setData(userService.update(userUpdateDTO));
        } catch (Exception e) {
            log.error("\ncom.fastdevelopinjava.service.ucenter.client.impl.UserClientImpl.update\n userUpdateDTO = {} \n  error = {} ", userUpdateDTO, e.getMessage());
            resultDTO.setSuccess(false);
            resultDTO.setMsg(e.getMessage());
        }
        return resultDTO;
    }
}
