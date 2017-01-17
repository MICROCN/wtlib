package com.wtlib.pojo;

import java.io.Serializable;

/**
 * ClassName: User
 * 
 * @Description: 一个普通的java类
 * @author dapengniao
 * @date 2016年6月25日 上午11:52:52
 */
public class User implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String pwd;
	private String role;
	
	public User() {}

	public User(String name, String pwd, String role) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
