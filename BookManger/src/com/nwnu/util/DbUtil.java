package com.nwnu.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * 
 * @author Administrator
 *
 */
public class DbUtil {
	// ���ݿ��ַ
	private static String dbUrl = "jdbc:mysql://123.207.168.154:3306/db_book";
	// �û���
	private static String dbUserName = "root";
	// ����
	private static String dbPassword = "pp211314";
	// ��������
	private static String jdbcName = "com.mysql.jdbc.Driver";
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * �ر����ݿ�
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
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
