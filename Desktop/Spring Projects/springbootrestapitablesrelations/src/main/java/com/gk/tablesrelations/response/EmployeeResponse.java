package com.gk.tablesrelations.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponse {
	
	private Long id;
	
	private String employeeName;
	
	private List<String> department;

}
