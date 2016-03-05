package com.wy.tool;

import java.sql.*;

public class JDBConnection {
	/*
	private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 数据库的驱动

	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_shopping"; // URL地址

	public Connection connection = null;

	public JDBConnection() {
		try {
			Class.forName(dbDriver).newInstance(); // 加载数据库驱动
			connection = DriverManager.getConnection(url, "sa", "root"); // 加载数据库 
			 System.out.println("Connection Successful!");  //如果连接成功 控制台输出Connection Successful!
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
	}
	*/
	public Connection connection = null;
	private String dbDriver = "com.mysql.jdbc.Driver"; // 数据库的驱动
	//private String url = "jdbc:mysql://localhost:3306;DatabaseName=db_shopping"; // URL地址
	private String url = "jdbc:mysql://localhost:3306/db_shopping"; // URL地址
	public JDBConnection() {
		try {
			Class.forName(dbDriver).newInstance(); // 加载数据库驱动
			connection = DriverManager.getConnection(url, "root", "root"); // 加载数据库 
			// System.out.println("Connection Successful!");  //如果连接成功 控制台输出Connection Successful!
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
		
	}
	
	
}