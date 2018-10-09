package com.hanleng.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanleng.entity.User;
import com.hanleng.mapper.UserMapper;
import com.hanleng.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;
	 
	@Override
	public User userlogin(User user) {
		return userMapper.userlogin(user);
	}

}
