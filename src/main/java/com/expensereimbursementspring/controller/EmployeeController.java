package com.expensereimbursementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/{eid}")
	EmployeePojo fetchEmployee(@PathVariable int eid) throws SystemException{
		log.info("Entered fetchEmployee of EmployeeController");
		return empService.fetchEmployee(eid);
	}
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	EmployeePojo loginEmployee(@RequestBody EmployeePojo pojoIn) throws SystemException{
		log.info("Entered loginEmployee of EmployeeController");
		return empService.loginEmployee(pojoIn);
	}
	
	@GetMapping("/")
	List<EmployeePojo> fetchAllEmployees() throws SystemException{
		log.info("Entered fetchAllEmployees of EmployeeController");
		return empService.fetchAllEmployees();
	}
	
	@RequestMapping(method= RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	EmployeePojo updateInfo(@RequestBody EmployeePojo pojoIn) throws SystemException{
		log.info("Entered updateInfo of EmployeeController");
		return empService.updateInfo(pojoIn);
	}

}
