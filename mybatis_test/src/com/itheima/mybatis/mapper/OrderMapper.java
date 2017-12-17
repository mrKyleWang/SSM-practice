package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.Orders;

public interface OrderMapper {

	// 查询订单order所有数据
	public List<Orders> selectOrdersList();

	// 一对一
	public List<Orders> selectOrders();

}
