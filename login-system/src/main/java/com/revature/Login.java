package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login  extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("<Head>");
			out.println("<Title>Servlet State Managment</Title>");
			out.println("</Head>");
			out.println("<Body>");
			
			out.println("<h2>Login Page</h2>\r\n"
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
			
			out.println("<form action=\"loggedIn\" method=\"get\">\r\n"
					+ "		<input type=\"text\" name=\"name\" placeholder=\"username\"/>\r\n"
					+ "		<input type=\"text\" name=\"password\" placeholder=\"password\"/>\r\n"
					+ "		<input type=\"submit\" value=\"Login\" />\r\n"
					+ "	</form>");
			
			
			
			out.println("</Body>");
			out.println("</Html>");

		}
	}
}
