package com.web.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtil {
	
	private static String DRIVERCLASS;
	
	private static String URL;
	
	private static String USER;
	
	private static String PASSWORD;
	
	
	/**
	 * 静态初始化块，程序第一次访问时执行
	 */
	public static void link(){
		
		Properties p = new Properties();
		InputStream in = null;
		try {
			in = DBUtil.class.getResourceAsStream("/com/web/util/db.properties"); 
//				new FileInputStream();
			p.load(in);
			
			DRIVERCLASS = p.getProperty("driverclass");
			URL = p.getProperty("url");
			USER = p.getProperty("user");
			PASSWORD = p.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 链接数据库，获取链接对象
	 * @return conn;
	 */
	public static Connection getConnection(){
		link();
		Connection conn = null;
		try {
			Class.forName(DRIVERCLASS);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * DML执行方法==>增删改。
	 * 注意：当sql语句中有？时，要传入相同个数的值组成的数组。
	 * @param sql
	 * @param obj
	 * @return 执行成功返回true
	 */
	public static boolean executeDML(String sql,Object[] obj){
		Connection conn = null;
		//预处理，预编译，支持占位符？ 占位符只代替一个值，
		PreparedStatement ps = null;
		boolean b = false;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			//sal语句带有问号需要设置参数
			if(null != obj&&obj.length>0){
				for(int i=0;i<obj.length;i++){
					ps.setObject((i+1), obj[i]);
				}
			}
			b = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
			if(ps != null) ps.close();
			if(conn != null) conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	}
	
	/**
	 * DQL执行方法==>查询
	 * 注意：当sql语句中有？时，要传入相同个数的值组成的数组。
	 * @param sql
	 * @param obj
	 */
	public static List<Object[]> executeDQL(String sql,Object[] obj){
		Connection conn = null;
		//预处理，预编译，支持占位符？ 占位符只代替一个值，
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			//sal语句带有问号需要设置参数
			if(null != obj&&obj.length>0){
				for(int i=0;i<obj.length;i++){
					ps.setObject((i+1), obj[i]);
				}
			}
			rs = ps.executeQuery();
			//处理结果集
			//获取结果的列数
			int columnCount = rs.getMetaData().getColumnCount();
			Object[] os = null;
			while(rs.next()){
				os = new Object[columnCount];
				for(int i=0;i<columnCount;i++){
					os[i] = rs.getObject(i+1);
				}
				list.add(os);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	

}
