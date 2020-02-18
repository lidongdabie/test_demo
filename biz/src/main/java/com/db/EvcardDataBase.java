package com.db;

/**
 * 处理主库的
 * 
 * @author jin wei
 * 
 */
public class EvcardDataBase extends DataBase {
	/**
	 * 构造函数，确保数据库连接正确
	 */
	public EvcardDataBase(String dataBaseName) {
		super("Evcard", dataBaseName);
	}
}