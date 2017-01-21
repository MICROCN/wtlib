package com.wtlib.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class BookBase {
    private Integer id;

    private String bookTitle;

    private String bookCoverUrl;

    private String bookDesc;

    private String bookWriter;

    private String bookPublisher;

    private Integer bookPageNum;

    private BigDecimal bookPrice;

    private String isReservated;

    private Integer creator;

    private Integer bookNum;

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

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle == null ? null : bookTitle.trim();
    }

    public String getBookCoverUrl() {
        return bookCoverUrl;
    }

    public void setBookCoverUrl(String bookCoverUrl) {
        this.bookCoverUrl = bookCoverUrl == null ? null : bookCoverUrl.trim();
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc == null ? null : bookDesc.trim();
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter == null ? null : bookWriter.trim();
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher == null ? null : bookPublisher.trim();
    }

    public Integer getBookPageNum() {
        return bookPageNum;
    }

    public void setBookPageNum(Integer bookPageNum) {
        this.bookPageNum = bookPageNum;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getIsReservated() {
        return isReservated;
    }

    public void setIsReservated(String isReservated) {
        this.isReservated = isReservated == null ? null : isReservated.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
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