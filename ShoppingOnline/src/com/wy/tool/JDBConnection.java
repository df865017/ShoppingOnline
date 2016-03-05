package com.wy.tool;

import java.sql.*;

public class JDBConnection {
	/*
	private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ���ݿ������

	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_shopping"; // URL��ַ

	public Connection connection = null;

	public JDBConnection() {
		try {
			Class.forName(dbDriver).newInstance(); // �������ݿ�����
			connection = DriverManager.getConnection(url, "sa", "root"); // �������ݿ� 
			 System.out.println("Connection Successful!");  //������ӳɹ� ����̨���Connection Successful!
		} catch (Exception ex) {
			System.out.println("���ݿ����ʧ��");
		}
	}
	*/
	public Connection connection = null;
	private String dbDriver = "com.mysql.jdbc.Driver"; // ���ݿ������
	//private String url = "jdbc:mysql://localhost:3306;DatabaseName=db_shopping"; // URL��ַ
	private String url = "jdbc:mysql://localhost:3306/db_shopping"; // URL��ַ
	public JDBConnection() {
		try {
			Class.forName(dbDriver).newInstance(); // �������ݿ�����
			connection = DriverManager.getConnection(url, "root", "root"); // �������ݿ� 
			// System.out.println("Connection Successful!");  //������ӳɹ� ����̨���Connection Successful!
		} catch (Exception ex) {
			System.out.println("���ݿ����ʧ��");
		}
		
	}
	
	
}