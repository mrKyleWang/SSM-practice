package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public interface UserMapper {
	// 根据id查询
	User queryUserById(int id);

	// 根据用户名查询用户
	List<User> queryUserByUsername(String username);

	// 保存用户
	void saveUser(User user);
	
	//用户名模糊查询
	public List<User> findUserByQueryVo(QueryVo vo);
	
	//查询数据条数
	public Integer countUser();
	
	//根据性别和名字查询用户
	public List<User> selectUserBySexAndUsername(User user);
	
	//根据对个id查询用户信息
	public List<User> selectUserByIds(Integer[] ids);
//	public List<User> selectUserByIds(List<Integer> ids);
//	public List<User> selectUserByIds(QueryVo vo);
	
	//多对一
	public List<User> selectUsers();
	
	
}