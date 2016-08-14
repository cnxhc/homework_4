package com.jkxy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jkxy.model.Poetries;
import com.jkxy.util.ConnectionFactory;

public class PoetriesService {
	PreparedStatement ps=null;
	Connection conn=ConnectionFactory.getInstance().makeConnection();
	
	/**
	 * 查询前200条记录
	 * @return 诗人名，诗人编号，诗词名称，诗词内容
	 */
	public List<Poetries> queryAllPoet(){
		List<Poetries> poes=new ArrayList<Poetries>();
		try {
			String sql="SELECT poet_id,`name`,title,content FROM poets,poetries WHERE poets.id=poetries.poet_id limit 0,200;";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Poetries poe=new Poetries();
				poe.setPoe_id(Integer.parseInt(rs.getString(1)));
				poe.setName(rs.getString(2));
				poe.setTitle(rs.getString(3));
				poe.setContent(rs.getString(4));
				poes.add(poe);
			}
			return poes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 通过诗人的名字查询该诗人的诗词名称
	 * @param name 诗人名
	 * @return 诗词名称
	 */
	public List<Poetries> queryTitleByName(String name){
		//String sql="SELECT title from poetries where poet_id=(SELECT id FROM poets WHERE name=?)";
		String sql="SELECT title from poetries,poets where poets.id=poetries.poet_id and name=?;";
		List<Poetries> poes=new ArrayList<Poetries>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);	
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Poetries poe=new Poetries();
				poe.setTitle(rs.getString(1));
				poes.add(poe);
			}
			return poes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	/**
	 * 通过诗词名称查询诗词的内容和诗人
	 * @param 诗词名称
	 * @return 返回诗词全文和诗人
	 */
	public List<Poetries> queryContentByTitle(String title){
		String sql="SELECT content,name FROM poets, poetries WHERE title=? and  poets.id=poetries.poet_id;";
		List<Poetries> contents=new ArrayList<Poetries>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,title);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Poetries poe=new Poetries();
				poe.setContent(rs.getString(1));
				poe.setName(rs.getString(2));
				contents.add(poe);
			}
			return contents;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 通过部分诗词名句查询诗人，诗词名称
	 * @param 诗词名句
	 * @return 返回诗人和诗词名称
	 */
	public List<Poetries> queryNameTitleByContent(String content){
		String sql="SELECT b.`name`,a.poet_id,a.title,a.content FROM poetries a  "
				+ "JOIN poets b WHERE a.content LIKE ? AND a.poet_id=b.id;";
		List<Poetries> poets=new ArrayList<Poetries>();
		try {
			
			if(!content.equals("")&& !content.contains("%")){
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+content+"%");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Poetries poe=new Poetries();
					poe.setName(rs.getString(1));
					poe.setPoe_id(rs.getInt(2));
					poe.setTitle(rs.getString(3));
					poe.setContent(rs.getString(4));
					poets.add(poe);
				}
			}
			return poets;
		} catch (Exception e) {
			e.printStackTrace();
			return poets;
		}
	}
}
