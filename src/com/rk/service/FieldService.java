package com.rk.service;

import java.util.List;

import com.rk.model.Field;

public interface FieldService {
	
	 Integer delete( Integer id) ;

	  List<Field> selectAll();
	  List<Field> selectUnfields();
	
	

	Integer update(Field record);

	Field selectById(Integer id);

	Integer addField(Field field);

	

}
