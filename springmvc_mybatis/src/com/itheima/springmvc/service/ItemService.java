package com.itheima.springmvc.service;

import java.util.List;

import com.itheima.springmvc.pojo.Items;

public interface ItemService {

	
	public List<Items> selectItemList();

	public Items selectItemsById(int id);
	
	public void updateItemsById(Items items);

}
