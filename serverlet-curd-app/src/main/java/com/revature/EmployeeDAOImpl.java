package com.revature;

import java.sql.*;
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
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
