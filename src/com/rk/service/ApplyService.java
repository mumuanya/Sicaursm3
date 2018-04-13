package com.rk.service;

import java.util.List;

import com.rk.model.Apply;

public interface ApplyService {
	
	//admin
	List<Apply> getAppling();
	List<Apply> getApplied();
	List<Apply> getReturning();
	List<Apply> getReturned();
	Integer agreeApl(Integer id);
    Integer refuseApl(Integer id);
    Integer agreeReturn(Integer id);
    
    //user
    Integer userApplySubmit(Apply record);
    Integer  userReturnApply(Integer id);
    List<Apply> userGetAppling(Integer id);
	List<Apply> userGetApplied(Integer id);
	List<Apply> userGetApph(Integer id);
}
