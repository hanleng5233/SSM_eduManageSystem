package com.hanleng.mapper;

import com.hanleng.entity.User;

public interface UserMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	//系统用户登录验证
	User userlogin(User user);

}