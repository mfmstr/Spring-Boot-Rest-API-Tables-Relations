package com.gk.tablesrelations.service;

import java.util.List;

import com.gk.tablesrelations.model.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees(int pageNumber, int pageSize);
	
	Employee saveEmployee(Employee employee);
	
	Employee getSingleEmployee (Long id);
	
	void deleteEmployee (Long id);
	
	Employee updateEmployee(Employee employee);
	
}

