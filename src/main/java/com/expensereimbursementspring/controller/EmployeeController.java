package com.expensereimbursementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.service.EmployeeService;

@Controller
@CrossOrigin("http://ec2-54-227-229-86.compute-1.amazonaws.com:9999")
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/{eid}")
	EmployeePojo fetchEmployee(@PathVariable int eid) {
		return empService.fetchEmployee(eid);
	}
	
	@PostMapping("/login")
	EmployeePojo loginEmployee(@RequestBody EmployeePojo pojoIn) {
		return empService.loginEmployee(pojoIn);
	}
	
	@GetMapping("/")
	List<EmployeePojo> fetchAllEmployees(){
		return empService.fetchAllEmployees();
	}
	
	@PutMapping("/")
	EmployeePojo updateInfo(@RequestBody EmployeePojo pojoIn) {
		return empService.updateInfo(pojoIn);
	}

}
