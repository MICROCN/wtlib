package com.wtlib.pojo;

import java.util.Date;

public class CreditInfo {
    private Integer id;

    private String creditName;

    private Integer miniUserLevelId;

    private String isPlus;

    private Integer creditValue;

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

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName == null ? null : creditName.trim();
    }

    public Integer getMiniUserLevelId() {
        return miniUserLevelId;
    }

    public void setMiniUserLevelId(Integer miniUserLevelId) {
        this.miniUserLevelId = miniUserLevelId;
    }

    public String getIsPlus() {
        return isPlus;
    }

    public void setIsPlus(String isPlus) {
        this.isPlus = isPlus == null ? null : isPlus.trim();
    }

    public Integer getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
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