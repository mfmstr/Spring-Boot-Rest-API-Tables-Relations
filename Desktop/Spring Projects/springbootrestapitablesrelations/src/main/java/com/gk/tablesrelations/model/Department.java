package com.gk.tablesrelations.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_department")
public class Department {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "Name should not be Null")
		private String name;
		
//		@ManyToOne One To Many Relationship
//		@JoinColumn(name = "employee_id")
//		private Employee employee;
		
		@ManyToOne
		@JoinColumn(name = "employee_id")
		private Employee employee;
		
//		@OneToOne(mappedBy = "department") <-- One to one bidirectional
//		private Employee employee;
	
	
}
