package com.gk.tablesrelations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gk.tablesrelations.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
	
	List<Employee> findByDepartmentName(String name);
	
	@Query("From Employee WHERE department.name = :name")
	List<Employee> getEmployeesByDepartmentName(String name);
}
