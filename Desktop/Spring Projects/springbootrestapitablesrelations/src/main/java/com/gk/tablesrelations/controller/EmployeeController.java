package com.gk.tablesrelations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gk.tablesrelations.model.Department;
import com.gk.tablesrelations.model.Employee;
import com.gk.tablesrelations.repository.DepartmentRepository;
import com.gk.tablesrelations.repository.EmployeeRepository;
import com.gk.tablesrelations.request.EmployeeRequest;
import com.gk.tablesrelations.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Autowired
	private DepartmentRepository dRepository;
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest){
		
		Employee employee = new Employee(eRequest);
		eRepository.save(employee);
		
		for(String s : eRequest.getDepartment()) {
			Department d = new Department();
			d.setName(s);
			d.setEmployee(employee);
			
			dRepository.save(d);
			
		}
		
		return new ResponseEntity<String>("Record saved successfully", HttpStatus.CREATED);
		
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		
		return new ResponseEntity<List <Employee>>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
	
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
	
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus>deleteEmployee(@RequestParam Long id) {
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
//	@PostMapping("/employees") ONE TO ONE RELATIOSHIP
//	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
//		
//		Department dept = new Department();
//		dept.setName(eRequest.getDepartment());
//		
//		dRepository.save(dept);
//		
//		Employee employee = new Employee(eRequest);
//		employee.setDepartment(dept);
//		
//		eRepository.save(employee);
//		
//		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
//		
//		
//	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
		
	}
	
//	@GetMapping("/employees/filter/{name}") <---------- ONE TO ONE
//	public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String name){
//		
//		// return new ResponseEntity<List<Employee>>(eRepository.findByDepartmentName(name), HttpStatus.OK);
//		
//		return new ResponseEntity<List<Employee>>(eRepository.getEmployeesByDepartmentName(name),HttpStatus.OK);
//		
//	}
	
}

