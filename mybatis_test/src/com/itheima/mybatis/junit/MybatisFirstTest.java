package com.itheima.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class MybatisFirstTest {

	@Test
	public void findUserById() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
	}

	@Test
	public void testFindUserByUsername() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		List<User> users = sqlSession.selectList("test.findUserByUsername", "五");

		for (User user : users) {
			System.out.println(user);
		}
	}

	// 添加用户
	@Test
	public void testInsertUser() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		User user = new User();
		user.setUsername("曾志伟");
		user.setBirthday(new Date());
		user.setAddress("香港尖沙咀");
		user.setSex("男");
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}

	// 更新用户
	@Test
	public void testUpdateUserById() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		User user = new User();
		user.setId(27);
		user.setUsername("曾志伟");
		user.setBirthday(new Date());
		user.setAddress("香港铜锣湾");
		user.setSex("男");
		sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
	}

	// 删除用户
	@Test
	public void testDelete() throws Exception {
		// 加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		sqlSession.update("test.deleteUserById", 26);
		sqlSession.commit();
	}

}
