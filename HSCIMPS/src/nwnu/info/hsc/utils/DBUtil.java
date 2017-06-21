package nwnu.info.hsc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库JDBC公共类
 * @author Administrator
 *
 */
public class DBUtil {

	static {
		//可以保证只加载一次，而且调用的时候肯定已经加载完成
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功！");
		} catch (Exception ex) {
			System.out.println("驱动加载失败！");
			ex.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection() {
		System.out.println("==============================");
		try {
			String url="jdbc:mysql://123.207.168.154:3306/hsc?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String pwd = "pp211314";
			Connection conn = DriverManager.getConnection(url,username,pwd);
			System.out.println("获取数据库连接成功！");
			return conn;
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败！");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 关闭连接
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取清单对象
	 * @param connection
	 * @return
	 */
	public static Statement getStatement(Connection connection) {
		Statement statement = null;
		try {
			//判断连接是否为空 如果为空创建一个新的
			if (connection == null) {
				connection = getConnection();
			}
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	/**
	 * 关闭清单对象
	 * @param statement
	 */
	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取预处理清单对象
	 * @param connection
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPstmt(Connection connection, String sql) {
		PreparedStatement preparedStatement = null;
		try {
			//判断连接是否为空 如果为空创建一个新的
			if (connection == null) {
				connection = getConnection();
			}
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	/**
	 * 关闭结果集合
	 * @param resultSet
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 释放所有的资源
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

}