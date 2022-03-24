package com.expensereimbursementspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementspring.pojo.AdminPojo;
import com.expensereimbursementspring.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/{aid}")
	AdminPojo fetchAdmin(int adminId) {
		return adminService.fetchAdmin(adminId);
	}
	
	@PostMapping("/login")
	AdminPojo loginAdmin(@RequestBody AdminPojo adminPojo) {
		return adminService.loginAdmin(adminPojo);
	}
	
	
}
