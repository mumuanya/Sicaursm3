package com.rk.service;

import java.util.List;

import com.rk.model.Item;


public interface ItemService {
	
	
	 Integer delete( Integer id) ;

	 List<Item> selectAll();
	
	Integer update(Item record);

	Item selectById(Integer id);

	List<Item> selectUnitems();


}
