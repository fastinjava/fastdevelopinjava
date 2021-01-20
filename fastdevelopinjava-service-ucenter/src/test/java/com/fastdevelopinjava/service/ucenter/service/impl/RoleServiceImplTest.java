package com.fastdevelopinjava.service.ucenter.service.impl;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.service.ucenter.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleServiceImplTest {


    @Resource
    private RoleService roleService;

    @Test
    public void insert() {
        RoleCreateDTO roleCreateDTO = new RoleCreateDTO();
        roleCreateDTO.setRoleCode("test_role");
        roleCreateDTO.setRoleName("测试角色");
        roleCreateDTO.setRoleDesc("测试角色");
        Boolean aBoolean = roleService.insert(roleCreateDTO);
        assertTrue(aBoolean);
    }
    @Test
    public void update() {
        RoleUpdateDTO roleUpdateDTO = new RoleUpdateDTO();
        roleUpdateDTO.setId(1);
        roleUpdateDTO.setRoleCode("test_role");
        roleUpdateDTO.setRoleName("测试角色update");
        roleUpdateDTO.setRoleDesc("测试角色1");
        roleUpdateDTO.setDeleteFlag("1");
        Boolean aBoolean = roleService.update(roleUpdateDTO);
        assertTrue(aBoolean);
    }

    @Test
    public void test1(){
        String body = HttpUtil.createGet("https://admin.wvenvir.com/bigData/communityGarbage/participationRateStatistics").execute().body();
        System.out.println(JSONUtil.toJsonPrettyStr(body));
    }
}
