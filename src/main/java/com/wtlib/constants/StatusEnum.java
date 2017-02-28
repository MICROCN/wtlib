package com.wtlib.constants;

public enum StatusEnum {
	DELETE(000, "删除"), COMMONUSE(001, "正常使用"), FAIL(002, "禁用");

	private Integer code;

	private final String value;

	StatusEnum(Integer code, String v) {
		this.code = code;
		value = v;
	}

	public String value() {
		return value;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
