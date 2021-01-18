package com.fastdevelopinjava.service.ucenter.service.impl;

import com.fastdevelopinjava.service.ucenter.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {



}
