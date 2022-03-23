package com.expensereimbursementspring.service;

import java.util.List;

import com.expensereimbursementspring.pojo.UserPojo;

public interface EmployeeService {
	
	UserPojo fetchEmployee(int empId);
	
	UserPojo loginEmployee(UserPojo userIn);
	
	List<UserPojo> fetchAllEmployees();
	
	UserPojo updateInfo(UserPojo userPojo);

}
