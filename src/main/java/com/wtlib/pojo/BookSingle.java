package com.wtlib.pojo;

import java.util.Date;

public class BookSingle {
    private Integer id;

    private Integer bookBaseId;

    private String bookHash;

    private Integer currentOwner;

    private Integer lastLender;

    private Date lastLendTime;

    private Integer creator;

    private Date createTime;

    private Integer reviser;

    private Date updateTime;

    private String dataStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookBaseId() {
        return bookBaseId;
    }

    public void setBookBaseId(Integer bookBaseId) {
        this.bookBaseId = bookBaseId;
    }

    public String getBookHash() {
        return bookHash;
    }

    public void setBookHash(String bookHash) {
        this.bookHash = bookHash == null ? null : bookHash.trim();
    }

    public Integer getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Integer currentOwner) {
        this.currentOwner = currentOwner;
    }

    public Integer getLastLender() {
        return lastLender;
    }

    public void setLastLender(Integer lastLender) {
        this.lastLender = lastLender;
    }

    public Date getLastLendTime() {
        return lastLendTime;
    }

    public void setLastLendTime(Date lastLendTime) {
        this.lastLendTime = lastLendTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReviser() {
        return reviser;
    }

    public void setReviser(Integer reviser) {
        this.reviser = reviser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }
}