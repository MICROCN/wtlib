package com.wtlib.pojo;

import java.util.Date;

public class CreditRecord {
    private Integer id;

    private Integer userId;

    private Integer creditInfoId;

    private Integer creditIsPlus;

    private String creditName;

    private Integer creditBeforeValue;

    private Integer creditValue;

    private Integer creditAfterValue;

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

    public Integer getCreditInfoId() {
        return creditInfoId;
    }

    public void setCreditInfoId(Integer creditInfoId) {
        this.creditInfoId = creditInfoId;
    }

    public Integer getCreditIsPlus() {
        return creditIsPlus;
    }

    public void setCreditIsPlus(Integer creditIsPlus) {
        this.creditIsPlus = creditIsPlus;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName == null ? null : creditName.trim();
    }

    public Integer getCreditBeforeValue() {
        return creditBeforeValue;
    }

    public void setCreditBeforeValue(Integer creditBeforeValue) {
        this.creditBeforeValue = creditBeforeValue;
    }

    public Integer getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
    }

    public Integer getCreditAfterValue() {
        return creditAfterValue;
    }

    public void setCreditAfterValue(Integer creditAfterValue) {
        this.creditAfterValue = creditAfterValue;
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