package com.expensereimbursementspring.service;

import org.springframework.stereotype.Service;

import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.AdminPojo;
import com.expensereimbursementspring.pojo.UserPojo;

public interface AdminService {
	
	AdminPojo fetchAdmin(int adminId) throws SystemException;
	
	AdminPojo loginAdmin(AdminPojo pojoIn) throws SystemException;

}
