package com.expensereimbursementspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementspring.pojo.AdminPojo;
import com.expensereimbursementspring.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/{aid}")
	AdminPojo fetchAdmin(@PathVariable int aid) {
		return adminService.fetchAdmin(aid);
	}
	
	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	AdminPojo loginAdmin(@RequestBody AdminPojo adminPojo) {
		return adminService.loginAdmin(adminPojo);
	}
	
	
}
