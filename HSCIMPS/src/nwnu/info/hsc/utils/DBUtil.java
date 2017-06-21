package nwnu.info.hsc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ�JDBC������
 * @author Administrator
 *
 */
public class DBUtil {

	static {
		//���Ա�ֻ֤����һ�Σ����ҵ��õ�ʱ��϶��Ѿ��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ���");
		} catch (Exception ex) {
			System.out.println("��������ʧ�ܣ�");
			ex.printStackTrace();
		}
	}

	/**
	 * ��ȡ����
	 * @return
	 */
	public static Connection getConnection() {
		System.out.println("==============================");
		try {
			String url="jdbc:mysql://123.207.168.154:3306/hsc?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String pwd = "pp211314";
			Connection conn = DriverManager.getConnection(url,username,pwd);
			System.out.println("��ȡ���ݿ����ӳɹ���");
			return conn;
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �ر�����
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
	 * ��ȡ�嵥����
	 * @param connection
	 * @return
	 */
	public static Statement getStatement(Connection connection) {
		Statement statement = null;
		try {
			//�ж������Ƿ�Ϊ�� ���Ϊ�մ���һ���µ�
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
	 * �ر��嵥����
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
	 * ��ȡԤ�����嵥����
	 * @param connection
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPstmt(Connection connection, String sql) {
		PreparedStatement preparedStatement = null;
		try {
			//�ж������Ƿ�Ϊ�� ���Ϊ�մ���һ���µ�
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
	 * �رս������
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
	 * �ͷ����е���Դ
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