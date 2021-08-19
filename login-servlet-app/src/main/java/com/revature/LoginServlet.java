package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "	<form method=\"get\" action=\"ProfileServlet\">\r\n"
				+ "		<input type=\"text\" name=\"name\" />\r\n"
				+ "		<input type=\"submit\" value=\"Submit\" />\r\n"
				+ "	</form>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		out.close();
		
	}
}
