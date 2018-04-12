package com.rk.service;

import java.util.List;

import com.rk.model.Apply;

public interface ApplyService {
	
	List<Apply> getAppling();
	List<Apply> getApplied();
	List<Apply> getReturning();
	List<Apply> getReturned();
	Integer agreeApl(Integer id);
    Integer refuseApl(Integer id);
    Integer agreeReturn(Integer id);
	
}
