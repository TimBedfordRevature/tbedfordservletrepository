package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Profile extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Servlet State Managment</Title>");
			out.println("</Head>");
			out.println("<Body>");
			
			out.println("<h1>Profile Page</h1>\r\n"
					+ "\r\n"
					+ "	<table>\r\n"
					+ "	<tr>\r\n"
					+ "		<form action=\"login\" method=\"get\">\r\n"
					+ "			<input type=\"submit\" value=\"login\" />\r\n"
					+ "		</form>\r\n"
					+ "\r\n"
					+ "		<form action=\"login\" method=\"get\">\r\n"
					+ "			<input type=\"submit\" value=\"logout\" />\r\n"
					+ "		</form>\r\n"
					+ "\r\n"
					+ "		<form action=\"profile\" method=\"get\">\r\n"
					+ "			<input type=\"submit\" value=\"profile\" />\r\n"
					+ "		</form>\r\n"
					+ "		\r\n"
					+ "		</tr>\r\n"
					+ "\r\n"
					+ "	</table>");
			
			// get cookies
				Cookie[] cookies = request.getCookies();
				boolean flag = false;
				String name = "";
				if(cookies == null) {
					out.println("<h1>You are not logged in. Go back to the login page</h1>");
					return;
				}else {
					for(Cookie c : cookies) {
						String tname = c.getName();
						if(tname.equals("user_name")) {
							flag = true;
							name = c.getValue();
						}
					}
				}
				if(flag) {
					out.println("<h1>Welcome"+ name +"</h1>");	
				}
//						Cookie[] cookies = request.getCookies();
//						boolean flag = false;
//						String name = "";
//						if(cookies == null) {
//							out.println("<h1>you are new user go to home page and submit your name</h1>");
//							return;
//						}else {
//							for(Cookie c : cookies) {
//								String tname =  c.getName();
//								if(tname.equals("user_name")){
//									flag = true;
//									name = c.getValue();
//								}
//							}
//						}
//						
//						if(flag) {
//							out.println("<h1>Hello, "+ name +" welcome back to my website..</h1>");	
//						}
			
			
			
			out.println("</Body>");
			out.println("</Html>");

		}
	}

}
