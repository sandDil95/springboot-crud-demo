package com.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//all the crud  db methods
	
}
