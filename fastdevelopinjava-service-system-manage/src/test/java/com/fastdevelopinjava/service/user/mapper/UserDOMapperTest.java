package com.fastdevelopinjava.service.user.mapper;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fastdevelopinjava.service.user.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDOMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void test1() {
        List<UserDO> userDOList = userMapper.selectList(null);
        System.out.println(JSONUtil.toJsonPrettyStr(userDOList));
    }

    @Test
    public void test2(){

        UserDO userDOExample = new UserDO();
        userDOExample.setUserId(1);
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>(userDOExample);
        UserDO userDO = userMapper.selectOne(queryWrapper);
        System.out.println(JSONUtil.toJsonPrettyStr(userDO));
    }

}