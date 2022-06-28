package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	Employee createEmployee(Employee u);
	Employee retrieveEmployeeById(int id);
	List<Employee> retrieveEmployee();
	Employee retrieveEmployeeByUsername(String username);
	boolean updateEmployee(Employee u);
	boolean deleteEmployeeById(int id);
}