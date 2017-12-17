package com.itheima.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	// 查询商品列表
	@RequestMapping("/item/itemlist.action")
	public ModelAndView queryItemList() {
		// 从数据库中查询
		List<Items> list = itemService.selectItemList();
		ModelAndView mav = new ModelAndView();
		// 数据
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}

	// 显示修改页面,入参:id
	@RequestMapping("/itemEdit.action")
	public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {

		Items items = itemService.selectItemsById(id);

		ModelAndView mav = new ModelAndView();
		// 数据
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
	}

	// 提交修改,入参:Items对象
	@RequestMapping("/updateitem.action")
	public ModelAndView updateItem(QueryVo vo) {
		// 修改
		itemService.updateItemsById(vo.getItems());

		ModelAndView mav = new ModelAndView();
		// 数据
		mav.setViewName("success");
		return mav;
	}

	@RequestMapping("/delete.action")
	public ModelAndView deleteItem(QueryVo vo) {
		// 修改
		itemService.updateItemsById(vo.getItems());

		ModelAndView mav = new ModelAndView();
		// 数据
		mav.setViewName("success");
		return mav;
	}

}
