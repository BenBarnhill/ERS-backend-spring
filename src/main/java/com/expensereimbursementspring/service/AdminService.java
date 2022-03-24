package com.expensereimbursementspring.service;

import com.expensereimbursementspring.pojo.AdminPojo;
import com.expensereimbursementspring.pojo.UserPojo;



public interface AdminService {
	
	AdminPojo fetchAdmin(int adminId);
	
	AdminPojo loginAdmin(AdminPojo pojoIn);

}
