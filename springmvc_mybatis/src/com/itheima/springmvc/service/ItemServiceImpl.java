package com.itheima.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemsMapper itemsMapper;
	
	//查询商品列表
	public List<Items> selectItemList(){
		
		return itemsMapper.selectByExampleWithBLOBs(null);
		
	}

	@Override
	public Items selectItemsById(int id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateItemsById(Items items) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
