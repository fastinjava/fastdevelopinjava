package com.fastdevelopinjava.service.ucenter.web.controller;

import com.fastdevelopinjava.framework.api.client.UserClient;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.common.res.Result;
import com.fastdevelopinjava.service.ucenter.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserClientImpl implements UserClient {
    @Resource
    private UserService userService;
    @GetMapping("/getOne")
    @Override
    public Result<UserDTO> getOne(UserReqDTO userReqDTO) {
        UserDTO userDTO = userService.getOne(userReqDTO);
        return null;
    }
}
