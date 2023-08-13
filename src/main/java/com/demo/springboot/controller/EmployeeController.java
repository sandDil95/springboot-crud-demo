package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.exception.ResourceNotFoundException;
import com.demo.springboot.model.Employee;

import com.demo.springboot.repository.EmployeeRepository;

import java.util.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	//create employee REST api
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {//create json request into java object
		return employeeRepository.save(employee);
	}
	
	//get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee would not exist with this id"));
		return ResponseEntity.ok(employee);
	}
	
	//update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee empDetails) {
		Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee would not exist with this id"));
		updateEmployee.setfName(empDetails.getfName());
		updateEmployee.setlName(empDetails.getlName());
		updateEmployee.setEmail(empDetails.getEmail());

		employeeRepository.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	// delete employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Deleted record successfully"));
		employeeRepository.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
