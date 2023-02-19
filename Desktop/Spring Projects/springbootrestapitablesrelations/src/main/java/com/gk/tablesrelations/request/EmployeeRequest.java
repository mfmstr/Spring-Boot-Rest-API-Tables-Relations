package com.gk.tablesrelations.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {

	private String name;
	
//	private String department; IN CASE OF ONE TO ONE RELATIONSHIP
	
	private String department;
	
}
