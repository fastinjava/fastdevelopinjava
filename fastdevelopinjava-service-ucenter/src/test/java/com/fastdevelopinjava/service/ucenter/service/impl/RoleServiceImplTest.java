package com.fastdevelopinjava.service.ucenter.service.impl;


import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelopinjava.framework.api.dto.RoleCreateDTO;
import com.fastdevelopinjava.framework.api.dto.RoleDTO;
import com.fastdevelopinjava.framework.api.dto.RoleReqDTO;
import com.fastdevelopinjava.framework.api.dto.RoleUpdateDTO;
import com.fastdevelopinjava.service.ucenter.service.RoleService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
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
    public void testOne(){

        RoleReqDTO roleReqDTO = new RoleReqDTO();
        //roleReqDTO.setId(1);//
        roleReqDTO.setRoleCode("test_role");
        RoleDTO roleDTO = roleService.getOne(roleReqDTO);
        System.out.println(JSONUtil.toJsonPrettyStr(roleDTO));

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
    public void test1() {
        String body = HttpUtil.createGet("https://admin.wvenvir.com/bigData/communityGarbage/participationRateStatistics").execute().body();
        System.out.println(JSONUtil.toJsonPrettyStr(body));
    }


    /**
     * alibaba JSON测试
     */
    @Test
    public void test2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject
                .fluentPut("success", true)
                .fluentPut("code", 1)
                .fluentPut("data",
                        new JSONObject().fluentPut("username", "lifuyong")
                                .fluentPut("age", 18)
                                .fluentPut("sex", "男"));
        Console.log(JSONUtil.toJsonPrettyStr(jsonObject));

    }

    @Test
    public void test3() {
        cn.hutool.json.JSONObject jsonObject = new cn.hutool.json.JSONObject();
        jsonObject.put("success", true).put("msg", "操作成功");
        Console.log(JSONUtil.toJsonPrettyStr(jsonObject));
    }

    /*
    * 使用mockito大致可以划分为以下几个步骤：
    * */
    @Test
    public void test4() {

//        使用 mockito 生成 Mock 对象；
//
        RoleServiceImplTest mock = mock(RoleServiceImplTest.class);

//        定义(并非录制) Mock 对象的行为和输出(expectations部分)；
//        调用 Mock 对象方法进行单元测试；
//
//        对 Mock 对象的行为进行验证。
    }


}
