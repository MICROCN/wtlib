package com.wtlib.pojo;

public class BookBaseLabelInfo extends BaseEntity {
	
	private Integer id;
	private Integer bookBaseId;
	private Integer labelInfoId;
	
	public BookBaseLabelInfo(Integer bookBaseId, Integer labelInfoId) {
		this.bookBaseId = bookBaseId;
		this.labelInfoId = labelInfoId;
	}
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
	public Integer getLabelInfoId() {
		return labelInfoId;
	}
	public void setLabelInfoId(Integer labelInfoId) {
		this.labelInfoId = labelInfoId;
	}
	
	
}
