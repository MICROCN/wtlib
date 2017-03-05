package com;

import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		System.out.println(uuid);
	}

}
