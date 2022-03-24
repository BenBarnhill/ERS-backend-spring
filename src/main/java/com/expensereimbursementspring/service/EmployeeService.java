package com.expensereimbursementspring.service;

import java.util.List;

import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.pojo.UserPojo;


public interface EmployeeService {
	
	EmployeePojo fetchEmployee(int empId);
	
	EmployeePojo loginEmployee(EmployeePojo pojoIn);
	
	List<EmployeePojo> fetchAllEmployees();
	
	EmployeePojo updateInfo(EmployeePojo pojoIn);

}
