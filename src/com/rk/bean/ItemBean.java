package com.rk.bean;

import com.rk.model.Item;

public class ItemBean {
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
    		this.state = "ÒÑ½è³ö";
    	if(state == 0)
    		this.state = "Î´½è³ö";
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
    
    public void setItem(Item i) {
    	this.borrowerId = i.getBorrowerId();
    	this.description = i.getDescription();
    	this.id = i.getId();
    	this.name = i.getName();
    	this.position = i.getPosition();
    	setState(i.getState());
    }
}