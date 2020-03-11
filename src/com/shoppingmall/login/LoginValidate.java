package com.shoppingmall.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginValidate {

	public boolean validateUserLogin(String uname, String password) {
		boolean flag = false;
		Connection con = null;

		try {
			con = createConnection();
			if(con != null) {
				Statement stat = con.createStatement();
				String qry = "SELECT * FROM employee_login_master WHERE username ='"+uname+"' AND password = '"+password+"' ";
				ResultSet rs = stat.executeQuery(qry);
				if(rs.next()) {
					flag=true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	public Connection createConnection() {
		System.out.println("Creating MYSql Database Connection");
		Connection connection = null;
		
		try {
			//Provide Databse Driver according to your databse
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Provide URL, Database and Credentials according to your database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingmall","root","root");
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			if(connection != null) {
				System.out.println("Connection Created Succefully.....");
			}
			return connection;
	}
}
