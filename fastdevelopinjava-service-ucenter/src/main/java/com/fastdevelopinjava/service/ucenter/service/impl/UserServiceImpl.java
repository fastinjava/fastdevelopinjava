package com.fastdevelopinjava.service.ucenter.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fastdevelopinjava.framework.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.api.dto.UserDTO;
import com.fastdevelopinjava.framework.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.common.querry.QuerryTypeEnum;
import com.fastdevelopinjava.framework.common.res.PageResultDTO;
import com.fastdevelopinjava.service.ucenter.convert.UserConvert;
import com.fastdevelopinjava.service.ucenter.mapper.UserDOMapper;
import com.fastdevelopinjava.service.ucenter.model.UserDO;
import com.fastdevelopinjava.service.ucenter.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserConvert userConvert;

    @Resource
    UserDOMapper userDOMapper;

    private QueryWrapper<UserDO> buildQueryWrapper(UserDO userDO, QuerryTypeEnum querryTypeEnum) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotEmpty(userDO.getUserId())) queryWrapper.eq("user_id", userDO.getUserId());
        return queryWrapper;
    }

    @Override
    public UserDTO getOne(UserReqDTO userReqDTO) {
        UserDO userDO = userConvert.userReqDTO2UserDO(userReqDTO);
        IPage<UserDO> pageInfo = userDOMapper.selectPage(new Page<>(1, 1), this.buildQueryWrapper(userDO, QuerryTypeEnum.GET_ONE));
        if (CollectionUtil.isNotEmpty(pageInfo.getRecords())) {
            return userConvert.userDO2UserDTO(pageInfo.getRecords().get(0));
        }
        return null;
    }

    @Override
    public PageResultDTO<UserDTO> getList(UserReqDTO userReqDTO) {
        UserDO userDO = userConvert.userReqDTO2UserDO(userReqDTO);
        Page<UserDO> page;
        if (userReqDTO.getPageable()) {
            page = new Page<>(userReqDTO.getPageNum(),userReqDTO.getPageSize());
        }
        else {
            Integer total = userDOMapper.selectCount(this.buildQueryWrapper(userDO, QuerryTypeEnum.GET_LIST));
            page = new Page<>(1,total);
        }
        Page<UserDO> pageInfo = userDOMapper.selectPage(
                page,
                this.buildQueryWrapper(userDO, QuerryTypeEnum.GET_LIST)
        );
        List<UserDO> userDOList = pageInfo.getRecords();
        List<UserDTO> userDTOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(userDOList))
        {
            userDTOList = userDOList.stream().map(user-> userConvert.userDO2UserDTO(user)).collect(Collectors.toList());
        }
        return new  PageResultDTO<>(pageInfo.getTotal(),userDTOList);
    }

    @Override
    public Boolean insert(UserCreateDTO userCreateDTO) {
        UserDO userDO = userConvert.userCreateDTO2UserDO(userCreateDTO);
        return userDOMapper.insertSelective(userDO) > 0;
    }

    @Override
    public Boolean update(UserUpdateDTO userUpdateDTO) {
        UserDO userDO = userConvert.userUpdateDTO2UserDO(userUpdateDTO);
        return userDOMapper.updateByPrimaryKeySelective(userDO) > 0;
    }
}
