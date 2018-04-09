package com.rk.model;

public class Apply {
    private Integer id;

    private Integer userid;

    private Integer borrowtype;

    private Integer tid;

    private Integer state;

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

    public Integer getBorrowtype() {
        return borrowtype;
    }

    public void setBorrowtype(Integer borrowtype) {
        this.borrowtype = borrowtype;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}