package com.rk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.ApplyMapper;
import com.rk.dao.FieldMapper;
import com.rk.dao.ItemMapper;
import com.rk.model.Apply;
import com.rk.model.Field;
import com.rk.model.Item;
import com.rk.service.ApplyService;

@Service("ApplyService")
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	ApplyMapper applymapper;

	@Autowired
	FieldMapper fieldmapper;
	
	@Autowired
	ItemMapper itemmapper;

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
	public Integer agreeApl(Integer id,String borrowtype) {
		Apply apply = null;
		Field field = null;
		Item item = null;
		if(borrowtype.equals("物品")) {
			//借用物品
			try {

				apply = applymapper.selectByPrimaryKey(id);
				Integer tid = apply.getTid();
				item = itemmapper.selectByPrimaryKey(tid);
				item.setState(1); // 使物品借出去
				item.setBorrowerId(apply.getUserid());// 设置场地的借用者ID
				apply.setState(1); // 通过审核 1为通过审核

				applymapper.updateByPrimaryKeySelective(apply);
				itemmapper.updateByPrimaryKeySelective(item);

			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return apply.getState();
			
		}else if(borrowtype.equals("场地")) {
			//借用场地
			try {

				apply = applymapper.selectByPrimaryKey(id);
				Integer tid = apply.getTid();
				field = fieldmapper.selectByPrimaryKey(tid);
				field.setState(1); // 使物品借出去
				apply.setState(1); // 通过审核 1为通过审核

				field.setBorrowerId(apply.getUserid()); // 设置场地的借用者ID

				applymapper.updateByPrimaryKeySelective(apply);
				fieldmapper.updateByPrimaryKeySelective(field);

			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return apply.getState();
			
		}else {
			//借用类型有误
			return -1;
		}
		
	}

	@Override
	public Integer refuseApl(Integer id) {
		Apply apply = null;
		try {

			apply = applymapper.selectByPrimaryKey(id);
			apply.setState(-1);

			applymapper.updateByPrimaryKey(apply);

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return apply.getState();

	}

	@Override
	public Integer agreeReturn(Integer id, String borrowtype) {
		// 到底是归还物品还是场地？？？？？？
		Apply apply = null;
		Field field = null;
		Item item = null;
		if (borrowtype != null && borrowtype.equals("物品")) {
			//借用的是物品
			try {
				apply = applymapper.selectByPrimaryKey(id);
				Integer tid = apply.getTid();

				item = itemmapper.selectByPrimaryKey(tid);
				item.setState(0);
				item.setBorrowerId(null);
				apply.setState(3);

				applymapper.updateByPrimaryKeySelective(apply);
				itemmapper.updateByPrimaryKeySelective(item);
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			return apply.getState();
		} else if (borrowtype != null && borrowtype.equals("场地")) {
			//借用场地
			try {
				apply = applymapper.selectByPrimaryKey(id);
				Integer tid = apply.getTid();

				field = fieldmapper.selectByPrimaryKey(tid);
				field.setState(0);
				field.setBorrowerId(null);
				apply.setState(3);

				applymapper.updateByPrimaryKeySelective(apply);
				fieldmapper.updateByPrimaryKeySelective(field);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}

			return apply.getState();
		} else {
			//传入了错误参数
			return -1;
		}

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
			applymapper.updateByPrimaryKeySelective(apply);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return apply.getState();

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

	@Override
	public Apply getApplyByid(Integer id) {
		Apply apply = null;
		try {
			apply = applymapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apply;
	}

}
