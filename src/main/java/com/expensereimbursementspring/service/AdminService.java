package com.expensereimbursementspring.service;

import com.expensereimbursementspring.pojo.UserPojo;

public interface AdminService {
	
	UserPojo fetchAdmin(int adminId);
	
	UserPojo loginAdmin(UserPojo userIn);

}
