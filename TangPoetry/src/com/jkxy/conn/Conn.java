package com.jkxy.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	public Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/tang_poetry?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String password="root";
			conn=DriverManager.getConnection(url,user,password);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
