package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setGender(gender);
		employee.setCountry(country);
		
		
		try {
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
			dao.addEmployee(employee);
			out.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\"\r\n"
					+ "        integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\r\n"
					+ "      \r\n"
					+ "      <style>\r\n"
					+ "        \r\n"
					+ "            .wrapper{ width: 60%; border: 2px solid black; margin: 0 auto; margin-top: 1%; \r\n"
					+ "                padding: 1%; background-color: rgb(202, 202, 202);\r\n"
					+ "\r\n"
					+ "            }\r\n"
					+ "            body{\r\n"
					+ "                background-color: rgb(245, 245, 245);\r\n"
					+ "            }\r\n"
					+ "            .header{ margin: 0 auto; margin-top: 5%;}\r\n"
					+ "        </style>\r\n"
					+ "\r\n"
					+ "    </head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "    <nav class=\"navbar navbar-light bg-dark fixed-top\">\r\n"
					+ "        <form action=\"ViewListServlet\" method=\"post\">\r\n"
					+ "            <button class=\"btn btn-outline-warning\" type=\"submit\">View List</button>\r\n"
					+ "        </form>\r\n"
					+ "    </nav>\r\n"
					+ "    \r\n"
					+ "\r\n"
					+ "    <div class=\"header\">\r\n"
					+ "        <h1 class=\"text-center\">Add Employee</h1>\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "    <div class=\"wrapper\">\r\n"
					+ "    <form action=\"addEmployee\" method=\"post\">\r\n"
					+ "        <div class=\"form-group\">\r\n"
					+ "          <label for=\"name\">Enter Name</label>\r\n"
					+ "          <input type=\"name\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"name\">\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"form-group\">\r\n"
					+ "            <label for=\"email\">Enter Email</label>\r\n"
					+ "            <input type=\"email\" name=\"email\" class=\"form-control\" id=\"email\" placeholder=\"name@email.com\">\r\n"
					+ "          </div>\r\n"
					+ "\r\n"
					+ "        <div class=\"form-group\">\r\n"
					+ "          <label for=\"country\">Select Country</label>\r\n"
					+ "          <select class=\"form-control\" name=\"country\" id=\"country\">\r\n"
					+ "                <option value=\"USA\">USA</option>\r\n"
					+ "                <option value=\"UK\">UK</option>\r\n"
					+ "                <option value=\"AU\">AU</option>\r\n"
					+ "                <option value=\"CO\">CO</option>\r\n"
					+ "          </select>\r\n"
					+ "        </div>\r\n"
					+ "\r\n"
					+ "        <div class=\"form-group\">\r\n"
					+ "            <label for=\"gender\">Select Gender</label>\r\n"
					+ "          <div class=\"form-check\">\r\n"
					+ "              <input class=\"form-check-input\" type=\"radio\" name=\"gender\" id=\"gender\" value=\"male\"> Male\r\n"
					+ "            </div>\r\n"
					+ "            <div class=\"form-check\">\r\n"
					+ "              <input class=\"form-check-input\" type=\"radio\" name=\"gender\" id=\"gender\" value=\"female\"> Female\r\n"
					+ "            </div>\r\n"
					+ "        </div>\r\n"
					+ "\r\n"
					+ "        <div class=\"form-group\">\r\n"
					+ "            <button class=\"btn btn-dark btn-block\" type=\"submit\" value=\"save\">Save</button>\r\n"
					+ "        </div>\r\n"
					+ "      </form>\r\n"
					+ "    </div>\r\n"
					+ "    <script>\r\n"
					+ "        alert('employee record inserted')\r\n"
					+ "    </script>\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		out.close();
	}
}
