package com.fastdevelopinjava.service.ucenter.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserCreateDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserReqDTO;
import com.fastdevelopinjava.framework.ucenter.api.dto.UserUpdateDTO;
import com.fastdevelopinjava.framework.ucenter.common.res.PageDTO;
import com.fastdevelopinjava.service.ucenter.convert.UserConvert;
import com.fastdevelopinjava.service.ucenter.mapper.UserDOMapper;
import com.fastdevelopinjava.service.ucenter.model.UserDO;
import com.fastdevelopinjava.service.ucenter.model.UserDOExample;
import com.fastdevelopinjava.service.ucenter.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDOMapper userMapper;

    @Resource
    UserConvert userConvert;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserDOExample buildUserDOExample(UserReqDTO userReqDTO) {
        UserDOExample userDOExample = new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        if (ObjectUtil.isNotEmpty(userReqDTO.getUserId())) {
            criteria.andUserIdEqualTo(userReqDTO.getUserId());
        }
        if (StringUtils.isNotEmpty(userReqDTO.getUserName())) {
            criteria.andUserNameLike("%" + userReqDTO.getUserName().trim() + "%");
        }
        return userDOExample;
    }

    @Override
    public UserDTO getOne(UserReqDTO userReqDTO) {
        UserDOExample userDOExample = this.buildUserDOExample(userReqDTO);
        userDOExample.setOrderByClause("user_id limit 1");
        UserDO userDO = userMapper.selectByExample(userDOExample).stream().findFirst().orElseGet(null);
        return ObjectUtil.isNotEmpty(userDO) ? userConvert.userDO2UserDTO(userDO) : null;
    }

    /**
     * @param userReqDTO
     * @return
     */
    @Override
    public PageDTO<UserDTO> getList(UserReqDTO userReqDTO) {
        PageHelper.startPage(userReqDTO.getPageNum(),
                userReqDTO.getPageable() ? userReqDTO.getPageSize() : 0,
                true,
                true,
                !userReqDTO.getPageable()
        );
        PageInfo<UserDO> pageInfo = new PageInfo<>(userMapper.selectByExample(buildUserDOExample(userReqDTO)));
        List<UserDO> userDOList = pageInfo.getList();
        long total = pageInfo.getTotal();
        List<UserDTO> userDTOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(userDOList)) {
            userDTOList = userDOList.stream().map(user -> userConvert.userDO2UserDTO(user)).collect(Collectors.toList());
        }
        return new PageDTO<>(total, userDTOList);
    }

    @Override
    public Boolean insert(UserCreateDTO userCreateDTO) {
        UserDO userDO = userConvert.userCreateDTO2UserDO(userCreateDTO);
        String password = userDO.getPassword();
        if (StringUtils.isBlank(password)) {
            throw new RuntimeException(" password 字段为空");
        }
        userDO.setCreatedTime(DateUtil.date());
        userDO.setUpdatedTime(DateUtil.date());
        return userMapper.insertSelective(userDO) > 0;
    }

    @Override
    public Boolean update(UserUpdateDTO userUpdateDTO) {
        UserDO userDO = userConvert.userUpdateDTO2UserDO(userUpdateDTO);
        userDO.setUpdatedTime(DateUtil.date());
        return userMapper.updateByPrimaryKeySelective(userDO) > 0;
    }
}
