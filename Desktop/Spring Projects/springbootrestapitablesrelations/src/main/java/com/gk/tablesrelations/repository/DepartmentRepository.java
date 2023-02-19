package com.gk.tablesrelations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.tablesrelations.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
