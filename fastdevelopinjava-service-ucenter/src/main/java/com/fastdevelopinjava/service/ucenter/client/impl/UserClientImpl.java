package com.fastdevelopinjava.service.ucenter.client.impl;

import com.fastdevelopinjava.framework.api.client.UserClient;
import com.fastdevelopinjava.framework.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.framework.common.res.ResultDTO;
import com.fastdevelopinjava.service.ucenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserClientImpl implements UserClient {
    @Resource
    private UserService userService;

    @GetMapping("/getOne")
    @Override
    public ResultDTO<UserDTO> selectOne(UserReqDTO userReqDTO) {
        ResultDTO<UserDTO> result = new ResultDTO<>();
        try {
            UserDTO userDTO = userService.getOne(userReqDTO);
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.client.impl.UserClientImpl.getOne error , {} ", e.getMessage());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultDTO<PageResultDTO<UserDTO>> selectList(UserReqDTO userReqDTO) {
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

    @Override
    public ResultDTO<Boolean> insert(UserCreateDTO userCreateDTO) {
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

    @Override
    public ResultDTO<Boolean> update(UserUpdateDTO userUpdateDTO) {
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
