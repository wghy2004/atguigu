package com.atguigu.datasource;

/**
 * 分配 database source 工具类
 * 
 * 数据库分为master(writeable)和slave(readonly)两种，通过本工具类指定使用哪一种
 * 
 */

public class DBContextHolder {
	public static final String MASTER = "master";
	public static final String SLAVE = "slave";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDBType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getDBType() {
		return contextHolder.get();
	}

	public static void clearDBType() {
		contextHolder.remove();
	}

	/**
	 * 强制使用master数据库
	 */
	public static void useMaster() {
		setDBType(MASTER);
	}

	/**
	 * 强制使用slave数据库
	 */
	public static void useSlave() {
		setDBType(SLAVE);
	}

	/**
	 * 使用默认的数据库列表，目前默认的是master
	 */
	public static void useDefault() {
		clearDBType();
	}

}