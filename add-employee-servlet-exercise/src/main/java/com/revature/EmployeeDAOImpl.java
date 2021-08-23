package com.revature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static Statement statement = null;
	Connection connection = null;
	
	public EmployeeDAOImpl() throws ClassNotFoundException {
		try {
			this.connection = ConnectionFactory.getConnection();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	

	@Override
	public void addEmployee(Employee employee) throws SQLException {
		String sql = "insert into employee (name, email, gender, country) values (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getEmail());
		preparedStatement.setString(3, employee.getGender());
		preparedStatement.setString(4, employee.getCountry());
		int count = preparedStatement.executeUpdate();
		if(count > 0) {
			System.out.println("Employee Saved");
		} else {
			System.out.println("ERROR: Somthing went wrong");
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		String sql = "delete from employee where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		if(count > 0) {
			System.out.println("Employee Deleted");
		} else {
			System.out.println("ERROR: Somthing went wrong");
		}
		
		
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		String sql = "select * from employee";
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		List<Employee> employees = new ArrayList();
		
		   while (resultSet.next()) {
	            int id = resultSet.getInt(1);
	            String name = resultSet.getString(2);
	            String email = resultSet.getString(3);
	            String gender = resultSet.getString(4);
	            String country = resultSet.getString(5);
	            Employee employee = new Employee(id, name, email, gender, country);
	            employees.add(employee);
	        }
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) throws SQLException {
		String sql = "select * from employee where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
				Employee employee = new Employee();
		   while (resultSet.next()) {
	            employee.setName(resultSet.getString(2));
	            employee.setEmail(resultSet.getString(3));
	            employee.setGender(resultSet.getString(4));
	            employee.setCountry(resultSet.getString(5)); 
	        }
		return employee;
	}

}
