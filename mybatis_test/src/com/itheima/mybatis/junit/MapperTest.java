package com.itheima.mybatis.junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.mapper.OrderMapper;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public class MapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		// 创建SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testQueryUserById() {
		// 获取sqlSession，和spring整合后由spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 从sqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行查询方法
		User user = userMapper.queryUserById(1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testMapperQueryVo() {
		// 获取sqlSession，和spring整合后由spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 从sqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行查询方法

		QueryVo vo = new QueryVo();
		User u = new User();
		u.setUsername("五");
		vo.setUser(u);
		List<User> list = userMapper.findUserByQueryVo(vo);
		for (User user : list) {
			System.out.println(user);
		}

		Integer count = userMapper.countUser();
		System.out.println(count);
		sqlSession.close();
	}

	// 查询订单order所有数据
	@Test
	public void testOrderList() {
		// 获取sqlSession，和spring整合后由spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 从sqlSession中获取Mapper接口的代理对象
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		// 执行查询方法

		List<Orders> list = orderMapper.selectOrdersList();
		for (Orders order : list) {
			System.out.println(order);
		}
		sqlSession.close();
	}

	// 根据性别和名字查询用户
	@Test
	public void testFindUserBySexAndUsername() {
		// 获取sqlSession，和spring整合后由spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 从sqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行查询方法

		User u = new User();
		u.setSex("");
		u.setUsername("张小明");
		List<User> list = userMapper.selectUserBySexAndUsername(u);
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	// 多个id查询用户
	@Test
	public void testFindUserByIds() {
		// 获取sqlSession，和spring整合后由spring管理
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 从sqlSession中获取Mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行查询方法
		/*
		 * QueryVo vo = new QueryVo(); List<Integer> ids = new ArrayList<>();
		 * ids.add(16); ids.add(22); ids.add(24); vo.setIdsList(ids); List<User> list =
		 * userMapper.selectUserByIds(vo);
		 */

		Integer[] ids = new Integer[3];
		ids[0] = 16;
		ids[1] = 22;
		ids[2] = 24;

		List<User> list = userMapper.selectUserByIds(ids);

		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	// 一对一
	@Test
	public void testOrders() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Orders> list = orderMapper.selectOrders();
		
		for (Orders order : list) {
			System.out.println(order);
		}
		sqlSession.close();
	}

	
	//多对一
	@Test
	public void testUsers() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.selectUsers();
		
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}
}
