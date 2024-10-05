package com.multidata.connect.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multidata.connect.main.dao.EntityDao;
import com.multidata.connect.main.db1.entities.StudentData;
import com.multidata.connect.main.db1.repositories.StudentRepository;
import com.multidata.connect.main.db2.entities.EmployeeData;
import com.multidata.connect.main.db2.repositories.EmployeeRepository;
import com.multidata.connect.main.db3.entities.Person;
import com.multidata.connect.main.db3.repositories.DataRepository;

@RestController
public class DemoController {
	
	
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	DataRepository dataRepo;
	
	@GetMapping("/data")
	public String addData() {
		
		studentRepo.save(new StudentData("shreyas","ketkar","shreyas.ketkar@live.com"));
		employeeRepo.save(new EmployeeData("shreyas","ketkar","shreyas.ketkar@live.com"));
		dataRepo.save( new Person("shreyas","ketkar","shreyas.ketkar@live.com"));
		
		return "Data Added";
		
		
		
		
	}
	
	@GetMapping("/getData")
	public ResponseEntity<String> getData()
	{
		return new ResponseEntity<String>( new EntityDao(getStudentData(), getEmployeeData()).toString(),HttpStatus.OK);
	}
	
	@GetMapping("/getStudent")
	public List<StudentData> getStudentData() {
		
		return studentRepo.findAll();
	
		
	}
	
	
	
	@GetMapping("/getData1")
	public List<Person>getData1()
	{
		return dataRepo.findAll();
	}
	
	
	
	@GetMapping("/getEmployee")
	public List<EmployeeData> getEmployeeData() {
		
		return employeeRepo.findAll();
	
		
	}
	
	
	
	
	

}
