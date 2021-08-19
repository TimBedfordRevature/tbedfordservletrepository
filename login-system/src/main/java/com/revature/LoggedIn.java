package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggedIn extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Servlet State Managment</Title>");
			out.println("</Head>");
			out.println("<Body>");
			
			String name  =request.getParameter("name");
			String password  =request.getParameter("password");
			
			out.println("<h1>Logged In</h1>\r\n"
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
			
			
			Cookie c = new Cookie("user_name", name);
			Cookie c1 = new Cookie("password", password);
			response.addCookie(c);
			response.addCookie(c1);
			
			out.println("<h2>Login successful</h2>");
			out.println("<h2>You can access your profile</h2>");
			
			
			
			out.println("</Body>");
			out.println("</Html>");

		}
	}

}
