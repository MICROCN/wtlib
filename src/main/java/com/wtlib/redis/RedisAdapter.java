                    package com.wtlib.redis;

/**
 * ClassName: RedisAdapter
 * 
 * @Description: 缁熶竴绠＄悊redis鍛藉悕绌洪棿,闃叉瀛樺偍涓嶅悓瀵硅薄鏃秌ey閲嶅
 * @author dapengniao
 * @date 2016骞�鏈�鏃�涓嬪崍2:57:12
 */
public enum RedisAdapter {
	IP_LOCATION("a", "CHUAN"), LATEST_MESSAGE("b",
			"lis"), USER("c", "USER_serId");

	// 缂撳瓨鍚嶇О
	private String cacheName;
	// 鍛藉悕绌洪棿锛屼綔涓簁ey鐨勫墠缂�敤浜庡尯鍒嗕笉鍚屽瓨鍌ㄧ被鍨嬩箣闂寸殑key
	private String nameSpace;

	/**
	 * @Description: TODO
	 * @param @param nameSpace 鍛藉悕绌洪棿锛屼綔涓簁ey鐨勫墠缂�敤浜庡尯鍒嗕笉鍚屽瓨鍌ㄧ被鍨嬩箣闂寸殑key
	 * @param @param cacheName 缂撳瓨鍚嶇О
	 * @author dapengniao
	 * @date 2016骞�鏈�鏃�涓嬪崍2:57:29
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
