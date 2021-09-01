package com.younes.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		String n= (String) session.getAttribute("username");
		   PrintWriter out = response.getWriter();  
		   out.print("Hello "+n);  
		
	}
	
}
