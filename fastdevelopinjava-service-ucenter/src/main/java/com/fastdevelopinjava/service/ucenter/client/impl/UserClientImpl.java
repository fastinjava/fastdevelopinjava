package com.fastdevelopinjava.service.ucenter.client.impl;

import com.fastdevelopinjava.framework.api.client.UserClient;
import com.fastdevelopinjava.framework.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;
import com.fastdevelopinjava.service.ucenter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "用户管理",tags = {"用户管理api"})
@Slf4j
@RestController
@RequestMapping("/user")
public class UserClientImpl implements UserClient {
    @Resource
    private UserService userService;

    @ApiOperation("用户详情")
    @PostMapping("/getOne")
    @Override
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
    @PostMapping("/selectList")
    @Override
    public ResultDTO<PageResultDTO<UserDTO>> selectList(@RequestBody UserReqDTO userReqDTO) {
        ResultDTO<PageResultDTO<UserDTO>> result = new ResultDTO<>();
        try {
            PageResultDTO<UserDTO> pageResultDTO = userService.getList(userReqDTO);
            result.setSuccess(true);
            result.setData(pageResultDTO);
        } catch (Exception e) {
            log.error("\ncom.fastdevelopinjava.service.ucenter.client.impl.UserClientImpl.selectList\n userReqDTO = {} \n  error = {} ", userReqDTO, e.getMessage());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    @ApiOperation("用户新增")
    @PostMapping("/insert")
    @Override
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
    @PostMapping("/update")
    @Override
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
