package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;

public interface UserMapper {
	// 根据id查询
	User findUserById(Integer id);

	
}