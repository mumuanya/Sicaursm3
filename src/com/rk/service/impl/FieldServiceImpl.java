package com.rk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.FieldMapper;
import com.rk.model.Field;
import com.rk.service.FieldService;

@Service("FieldService")
public class FieldServiceImpl implements FieldService {
	
	@Autowired
	FieldMapper fieldmapper ;

	@Override
	public List<Field> selectAll() {
		List<Field> field = null;
		
		try {
			field = fieldmapper.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return field;
	}
	
	@Override
	public Integer delete(Integer id) {
	
		try {
			return fieldmapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


	@Override
	public Integer update(Field record) {
		try {
			return fieldmapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public Field selectById(Integer id) {
		
		
		return fieldmapper.selectByPrimaryKey(id); 
		
	}

	@Override
	public List<Field> selectUnfields() {
         
		List<Field> field = null;
		
		try {
			field = fieldmapper.selectBystate(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return field;
	}

	@Override
	public Integer addField(Field field) {
		Integer rs = null;
		
		try {
			rs = fieldmapper.insertSelective(field);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("≤Â»Îfield ß∞‹");
		}
		return rs;
	}
        
}
