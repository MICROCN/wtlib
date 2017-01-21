package com.wtlib.pojo;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private Integer userId;

    private String currentCreditLevel;

    private Integer currentCreditValue;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCurrentCreditLevel() {
        return currentCreditLevel;
    }

    public void setCurrentCreditLevel(String currentCreditLevel) {
        this.currentCreditLevel = currentCreditLevel == null ? null : currentCreditLevel.trim();
    }

    public Integer getCurrentCreditValue() {
        return currentCreditValue;
    }

    public void setCurrentCreditValue(Integer currentCreditValue) {
        this.currentCreditValue = currentCreditValue;
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