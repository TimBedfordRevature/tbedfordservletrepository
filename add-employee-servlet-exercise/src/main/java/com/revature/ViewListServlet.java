package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewListServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\"\r\n"
				+ "        integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">"
				+ "<style>\r\n"
				+ "\r\n"
				+ "        body{\r\n"
				+ "            background-color: #ccc;\r\n"
				+ "        }\r\n"
				+ "    .wrapper{\r\n"
				+ "        width: 90%; border: 1px solid black; margin: 0 auto; margin-top: 5%; background-color: white;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "</style>"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<nav class=\"navbar navbar-light bg-dark fixed-top\">\r\n"
				+ "         <form action=\"index.html\" method=\"post\">\r\n"
				+ "            <button class=\"btn btn-outline-warning\" type=\"submit\">Add Employee</button>\r\n"
				+ "        </form>"
				+ "    </nav>"
				+ "<div class=\"wrapper\">"
				+ "\r\n"
				+ "    <table class=\"table table-striped\">\r\n"
				+ "  <thead class=\"thead-dark\">\r\n"
				+ "    <tr>\r\n"
				+ "        <th scope=\"col\">ID</th>\r\n"
				+ "        <th scope=\"col\">Name</th>\r\n"
				+ "        <th scope=\"col\">Email</th>\r\n"
				+ "        <th scope=\"col\">gender</th>\r\n"
				+ "        <th scope=\"col\">Country</th>\r\n"
				+ "        <th scope=\"col\">Edit/Delete</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "  <tbody>");
		ViewListServlet vsl = new ViewListServlet();
		try {
			vsl.listEmployee(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println(" </tbody>\r\n"
				+ "</table>\r\n"
				+ "</div>"
				+ "</body>\r\n"
				+ "</html>");

	}
	public static void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
        List<Employee> listEmployees = dao.getEmployees();
        int i = 0;
        while(i < listEmployees.size()) {
        	out.println("<tr>");
        	out.println("<td>" + listEmployees.get(i).getId() + "</td>");
        	out.println("<td>" + listEmployees.get(i).getName() + "</td>");
        	out.println("<td>" + listEmployees.get(i).getEmail() + "</td>");
        	out.println("<td>" + listEmployees.get(i).getGender() + "</td>");
        	out.println("<td>" + listEmployees.get(i).getCountry() + "</td>");
        	out.println("<td><a href=\"edit?id=<c:out value='${user.id}' />\">Edit</a>\r\n"
        			+ "                <a>/</a>\r\n"
        			+ "                <a href=\"delete?id=<c:out value='${user.id}' />\">Delete</a>\r\n"
        			+ "            </td>");
        	out.println("</tr>");
        	i++;
        }
//        request.setAttribute("listEmployees", listEmployees);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//        dispatcher.forward(request, response);
    }
}
