package com.rk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.ApplyMapper;
import com.rk.dao.FieldMapper;
import com.rk.model.Apply;
import com.rk.model.Field;
import com.rk.service.ApplyService;

@Service("ApplyService")
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	ApplyMapper applymapper ;
	
	@Autowired
	FieldMapper fieldmapper ;

	@Override
	public List<Apply> getAppling() {
           
		List<Apply> apply = null;
		
		try {
			apply = applymapper.selectBystate(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return apply;
		
	}

	@Override
	public List<Apply> getApplied() {
          
		List<Apply> apply = null;
		
		try {
			apply = applymapper.selectBystate(1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return apply;
		
	}

	@Override
	public List<Apply> getReturning() {
             
		List<Apply> apply = null;
		
		try {
			apply = applymapper.selectBystate(2);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return apply;
		
	}

	@Override
	public List<Apply> getReturned() {
		
        List<Apply> apply = null;
		try {
			apply = applymapper.selectBystate(3);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return apply;
		
	}

	@Override
	public Integer agreeApl(Integer id) {
		Apply apply = null;
		Field field = null;
		try {
			
		apply = applymapper.selectByPrimaryKey(id);
		Integer tid =apply.getTid();
		
		field = fieldmapper.selectByPrimaryKey(tid);
		field.setState(1);
		apply.setState(1);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return apply.getState() ;
	}

	@Override
	public Integer refuseApl(Integer id) {
		Apply apply = null;
		try {
			
		apply = applymapper.selectByPrimaryKey(id);
		apply.setState(-1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return apply.getState() ;
		
	}

	@Override
	public Integer agreeReturn(Integer id) {
		Apply apply = null;
		Field field = null;
		try {
			
		apply = applymapper.selectByPrimaryKey(id);
		Integer tid =apply.getTid();
		
		field = fieldmapper.selectByPrimaryKey(tid);
		field.setState(0);
		apply.setState(3);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return apply.getState() ;
	}

	
	
	@Override
	public Integer userApplySubmit(Apply record) {
		
		try {
			return applymapper.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}

	@Override
	public Integer userReturnApply(Integer id) {
		Apply apply = null;
		try {
			
		apply = applymapper.selectByPrimaryKey(id);
		apply.setState(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return apply.getState() ;
		

	}

	@Override
	public List<Apply> userGetAppling(Integer id) {
		List<Apply> apply = null;
		try {
			apply = applymapper.selectBysi(id, 0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return apply;
	}

	@Override
	public List<Apply> userGetApplied(Integer id) {
		List<Apply> apply = null;
		try {
			apply = applymapper.selectBysi(id, 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return apply;
	}

	@Override
	public List<Apply> userGetApph(Integer id) {
		List<Apply> apply = null;
		try {
			apply = applymapper.selectBysi(id, 3);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return apply;
	}
	

}
