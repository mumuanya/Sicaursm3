package com.rk.bean;

import com.rk.model.Apply;

public class ApplyBean {
	
    private Integer id;

    private Integer userid;

    private String username;
    
    private String itemfieldname;
    
    public String getItemfieldname() {
		return itemfieldname;
	}

	public void setItemfieldname(String itemfieldname) {
		this.itemfieldname = itemfieldname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String borrowtype;

    private Integer tid;

    private String state;

    private String borrowreason;

    private Integer borrowtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getBorrowtype() {
        return borrowtype;
    }

    public void setBorrowtype(Integer borrowtype) {
    	if(borrowtype == 0)
    		this.borrowtype = "场地";
    	if(borrowtype == 1)
    		this.borrowtype = "物品";
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getState() {
        return state;
    }

    public void setState(Integer state) {
    	if(state == 0)
    		this.state = "正在申请";
    	if(state == 1)
    		this.state = "已审批";
    	if(state == 2)
    		this.state = "申请归还中";
    	if(state == 3)
    		this.state = "已完成";
    }

    public String getBorrowreason() {
        return borrowreason;
    }

    public void setBorrowreason(String borrowreason) {
        this.borrowreason = borrowreason == null ? null : borrowreason.trim();
    }

    public Integer getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Integer borrowtime) {
        this.borrowtime = borrowtime;
    }
    
    public void setApply(Apply a,String username,String itemfieldname) {
    	this.borrowreason = a.getBorrowreason();
    	this.borrowtime = a.getBorrowtime();
    	setBorrowtype(a.getBorrowtype());
    	this.id = a.getId();
    	setState(a.getState());
    	this.tid = a.getTid();
    	this.userid = a.getUserid();
    	this.username = username;
    	this.itemfieldname = itemfieldname;
    }
}
