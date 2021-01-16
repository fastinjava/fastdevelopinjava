package com.fastdevelopinjava.service.user.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.system.manage.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.service.user.convert.UserConvert;
import com.fastdevelopinjava.service.user.entity.UserDO;
import com.fastdevelopinjava.service.user.mapper.UserMapper;
import com.fastdevelopinjava.service.user.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserConvert userConvert;

    @Override
    public Boolean insertSelective(UserCreateDTO userCreateDTO) {
        UserDO userDO = userConvert.userCreateDTO2UserDO(userCreateDTO);
        return userMapper.insert(userDO) > 0;
    }

    @Override
    public PageResultDTO<UserDTO> selectList(UserReqDTO userReqDTO) {



        UserDO userDO = userConvert.userReqDTO2UserDO(userReqDTO);

        Wrapper<UserDO> queryWrapper = new QueryWrapper<>(userDO);

        if (!userReqDTO.getEnablePage()) {
            userReqDTO.setPageSize(userMapper.selectCount(queryWrapper));
        }

        IPage<UserDO> page = new Page<>(userReqDTO.getPageNum(), userReqDTO.getPageNum());

        IPage<UserDO> pageInfo = userMapper.selectPage(page, queryWrapper);

        List<UserDO> userDOList = pageInfo.getRecords();
        List<UserDTO> userDTOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(userDOList)) {
            userDTOList = userDOList.stream().map(user -> userConvert.user2UserDTO(user)).collect(Collectors.toList());
        }

        PageResultDTO<UserDTO> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setTotal(pageInfo.getTotal());
        pageResultDTO.setList(userDTOList);

        return pageResultDTO;
    }

    @Override
    public Boolean updateByPrimaryKeySelective(UserUpdateDTO userUpdateDTO) {
        UserDO userDO = userConvert.userUpdateDTO2UserDO(userUpdateDTO);
        UpdateWrapper<UserDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", userDO.getUserId());
        int update = userMapper.update(userDO, updateWrapper);
        return update > 0;
    }

    @Override
    public Boolean deleteByPrimaryKey(Integer userId) {
        Map<String, Object> columnMap = new HashMap<>(1);
        columnMap.put("user_id", userId);
        int i = userMapper.deleteByMap(columnMap);
        return i > 0;
    }

    @Override
    public UserDTO selectByPrimaryKey(Integer userId) {
        UserDO userDO = userMapper.selectOne(new QueryWrapper<>(UserDO.builder().userId(userId).build()));
        UserDTO userDTO = userConvert.user2UserDTO(userDO);
        return userDTO;
    }
}
