package com.nwnu.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * 
 * @author Administrator
 *
 */
public class DbUtil {
	// 数据库地址
	private static String dbUrl = "jdbc:mysql://123.207.168.154:3306/db_book";
	// 用户名
	private static String dbUserName = "root";
	// 密码
	private static String dbPassword = "pp211314";
	// 驱动名称
	private static String jdbcName = "com.mysql.jdbc.Driver";
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * 关闭数据库
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
