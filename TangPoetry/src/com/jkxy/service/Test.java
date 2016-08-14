package com.jkxy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jkxy.conn.Conn;

public class Test {
	public static void main(String[] args) {
		Connection conn=new com.jkxy.conn.Conn().getConnection();
		String sql="select * from poetries;";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.print(rs.getInt("id")+" ");
				System.out.print(rs.getInt("poet_id")+" ");
				System.out.print(rs.getString("content")+" ");
				System.out.print(rs.getString("title")+" ");
				System.out.print(rs.getDate("created_at")+" ");
				System.out.print(rs.getDate("updated_at")+" ");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
	}
}
