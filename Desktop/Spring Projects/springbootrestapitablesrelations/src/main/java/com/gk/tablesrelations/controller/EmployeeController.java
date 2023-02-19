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

import com.gk.tablesrelations.model.Employee;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
//	@Value("${app.name}")
//	private String appName;
//	
//	@Value("${app.version}")
//	private String appVersion;
	
	@Autowired
	private EmployeeService eService;
	
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
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
		
	}
	
}

