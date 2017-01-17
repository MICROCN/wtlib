package com.wtlib.redis;

/**
 * ClassName: RedisAdapter
 * 
 * @Description: 统一管理redis命名空间,防止存储不同对象时key重复
 * @author dapengniao
 * @date 2016年7月4日 下午2:57:12
 */
public enum RedisAdapter {
	IP_LOCATION("a", "以ip为key存放这个ip所属的地址"), LATEST_MESSAGE("b",
			"list结构存储用户最近n条消息"), USER("c", "string结构存储已登入用户的唯一cookie和userId");

	// 缓存名称
	private String cacheName;
	// 命名空间，作为key的前缀用于区分不同存储类型之间的key
	private String nameSpace;

	/**
	 * @Description: TODO
	 * @param @param nameSpace 命名空间，作为key的前缀用于区分不同存储类型之间的key
	 * @param @param cacheName 缓存名称
	 * @author dapengniao
	 * @date 2016年7月4日 下午2:57:29
	 */
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
