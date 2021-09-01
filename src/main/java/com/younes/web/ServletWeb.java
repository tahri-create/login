package com.younes.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ServletWeb extends HttpServlet{
	
	
	
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
	  	String username= request.getParameter("user");
    	String password=request.getParameter("pass");
    
    	UserBean bean=new UserBean();
    	bean.setName(username);
    	bean.setPass(password);
    	
    	UserDao utilisateur =new UserDao();	
    	try {
    		
			if(utilisateur.validate(bean)) {
				HttpSession session = request.getSession();
				 session.setAttribute("username",username);
				 response.sendRedirect("well.jsp");
			}else {
				response.sendRedirect("NewFile.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error!!");
			e.printStackTrace();
		}
    	
    	
	}
	
	
}
