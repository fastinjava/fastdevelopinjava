package com.fastdevelopinjava.service.ucenter.web.controller;

import com.fastdevelopinjava.framework.api.client.UserClient;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
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
    public ResultDTO<UserDTO> getOne(UserReqDTO userReqDTO) {
        ResultDTO<UserDTO> result = new ResultDTO<>();
        try {
            UserDTO userDTO = userService.getOne(userReqDTO);
        } catch (Exception e) {
            log.error("com.fastdevelopinjava.service.ucenter.web.controller.UserClientImpl.getOne error , {} ", e.getMessage());
            result.setSuccess(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultDTO<PageResultDTO<UserDTO>> getList(UserReqDTO userReqDTO) {
        PageResultDTO<UserDTO> pageResultDTO = userService.getList(userReqDTO);
        return null;
    }
}
