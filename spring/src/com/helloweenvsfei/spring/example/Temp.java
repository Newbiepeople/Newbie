package com.helloweenvsfei.spring.example;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class Temp {

	public static void main(String[] args) {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setDefaultAutoCommit(false);
		dataSource.setMaxActive(100);

		Properties props = new Properties() {
			{
				put("url", "http://www.helloweenvsfei.com");
				put("name", "helloweenvsfei");
			}
		};

	}

}
