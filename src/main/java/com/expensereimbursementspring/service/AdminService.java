package com.expensereimbursementspring.service;

import org.springframework.stereotype.Service;

import com.expensereimbursementspring.pojo.AdminPojo;
import com.expensereimbursementspring.pojo.UserPojo;

public interface AdminService {
	
	AdminPojo fetchAdmin(int adminId);
	
	AdminPojo loginAdmin(AdminPojo pojoIn);

}
