package com.gk.tablesrelations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gk.tablesrelations.model.Employee;
import com.gk.tablesrelations.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployees(int pageNumber, int pageSize) {
		
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.ASC, "id");
		
		return eRepository.findAll(pages).getContent();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return eRepository.save(employee);
		
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		
		Optional<Employee> employee = eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id:" + id);
	}

	@Override
	public void deleteEmployee(Long id) {
		
		eRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return eRepository.save(employee);
		
	}
		
	
}
