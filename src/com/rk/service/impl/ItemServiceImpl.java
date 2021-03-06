package com.rk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.ItemMapper;
import com.rk.model.Item;
import com.rk.service.ItemService;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {
	
	
	@Autowired
	ItemMapper itemmapper ;

	@Override
	public List<Item> selectAll() {
		List<Item> item = null;
		
		try {
			item = itemmapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return item;
	}
	
	@Override
	public Integer delete(Integer id) {
	
		try {
			return itemmapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


	@Override
	public Integer update(Item record) {
		try {
			return itemmapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Item selectById(Integer id) {
		
		
		return itemmapper.selectByPrimaryKey(id); 
		
	}

	@Override
	public List<Item> selectUnitems() {
           
		List<Item> item = null;
		
		try {
			item = itemmapper.selectBystate(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return item;
	}

	@Override
	public Integer addItem(Item item) {
		Integer rs = null;
		try {
			rs = itemmapper.insertSelective(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
