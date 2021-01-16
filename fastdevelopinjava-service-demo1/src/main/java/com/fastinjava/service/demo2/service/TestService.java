package com.fastinjava.service.demo2.service;

import com.fastdevelopinjava.framework.api.system.manage.client.UserClient;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.common.res.ResResultDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    @Reference
    private UserClient userclient;

    public Object test(){
        UserReqDTO userReqDTO = new UserReqDTO();
        userReqDTO.setUserId(1);
        ResResultDTO<UserDTO> resResultDTO = userclient.selectOneByAll(userReqDTO);
        return resResultDTO;
    }

}
