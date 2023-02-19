package com.gk.tablesrelations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.tablesrelations.model.Department;
import com.gk.tablesrelations.repository.DepartmentRepository;
import com.gk.tablesrelations.response.DepartmentResponse;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentRepository dRepository;
	
	@GetMapping("/departments")
	public List<DepartmentResponse> getDepartments(){
		List<Department> depts = dRepository.findAll();
		List<DepartmentResponse> list = new ArrayList<>();
		depts.forEach(d -> {
			DepartmentResponse dResponse = new DepartmentResponse();
			dResponse.setDepartmentName(d.getName());
			dResponse.setId(d.getId());
			dResponse.setEmployeeName(d.getEmployee().getName());
			list.add(dResponse);
		});
		return list;
	}
}
