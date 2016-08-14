package com.jkxy.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 通过工厂模式获取数据库连接
 * 
 * @author Administrator
 *
 */
public class ConnectionFactory {
	private static String driver;// 驱动程序名
	private static String dburl;// 连接字符串
	private static String user;// 用户名
	private static String password;// 密码
	private static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn;
	/*
	 * 静态代码块加载配置文件dbconfig.properties
	 */
	static {
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			System.out.println("==========配置文件读取错误==========");
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}

	public ConnectionFactory() {
		// TODO Auto-generated constructor stub
	}

	public static ConnectionFactory getInstance() {
		return factory;
	}

	/**
	 * 加载mysql驱动程序
	 * 
	 * @return 返回数据库连接
	 */

	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
