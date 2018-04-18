package com.rk.bean;

import com.rk.model.Field;

public class FieldBean {
    private Integer id;

    private String name;

    private String description;

    private String state;

    private String position;

    private Integer borrowerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(Integer state) {
    	if(state == 1)
    		this.state = "�ѽ��";
    	if(state == 0)
    		this.state = "δ���";
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }
    
    public void setField(Field f) {
    	this.id = f.getId();
    	this.borrowerId = f.getBorrowerId();
    	this.description = f.getDescription();
    	this.name = f.getName();
    	this.position = f.getPosition();
    	setState(f.getState());
    }
    
}