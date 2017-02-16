package com;

public class Test {

	public static void main(String[] args) {
		System.out.println("cbjcl0204@163.com".matches("^[1]([0-9][0-9])[0-9]{8}$"));
		System.out.println("@".contains("@"));
		System.out.println("123456@sina.com".matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"));
	}

}
