package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.springboot.model.Employee;
import com.demo.springboot.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setfName("ABC");
		employee.setlName("XYZ");
		employee.setEmail("abc@gmail.com");
		employeeRepository.save(employee);
		
		Employee employee2 = new Employee();
		employee2.setfName("EFG");
		employee2.setlName("STU");
		employee2.setEmail("efg@gmail.com");
		employeeRepository.save(employee2);
	}

}
