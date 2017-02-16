<<<<<<< HEAD
package com.wtlib.redis;

public enum RedisAdapter {
	IP_LOCATION("a", "CHUAN"), LATEST_MESSAGE("b", "lis"), USER("c",
			"USER_serId");

	private String cacheName;
	private String nameSpace;

	private RedisAdapter(String nameSpace, String cacheName) {
		this.nameSpace = nameSpace;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

}
=======
package com.wtlib.redis;

public enum RedisAdapter {
	IP_LOCATION("a", "CHUAN"), LATEST_MESSAGE("b", "lis"), USER("c",
			"USER_serId");

	private String cacheName;
	private String nameSpace;

	private RedisAdapter(String nameSpace, String cacheName) {
		this.nameSpace = nameSpace;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
