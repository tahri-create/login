package com.younes.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public boolean validate(UserBean bean) throws ClassNotFoundException {

		boolean status=false; 
		
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/user";
		String user ="root";
		String pass="Qweasdzxc123";
		String sql="Select * from login where user= ? and pass= ?; ";
			
		try {
			Connection connection=DriverManager.getConnection(url,user,pass);
 			PreparedStatement st=connection.prepareStatement(sql);
			st.setString(1, bean.getName());
			st.setString(2, bean.getPass()); 
			
			ResultSet rs=st.executeQuery();
			
			if(rs.next()){
				status=true;
			}else{
				status=false;
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
}
