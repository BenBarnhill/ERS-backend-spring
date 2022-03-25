package com.expensereimbursementspring.service;

import java.util.List;

import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.pojo.UserPojo;


public interface EmployeeService {
	
	EmployeePojo fetchEmployee(int empId) throws SystemException;
	
	EmployeePojo loginEmployee(EmployeePojo pojoIn) throws SystemException;
	
	List<EmployeePojo> fetchAllEmployees() throws SystemException;
	
	EmployeePojo updateInfo(EmployeePojo pojoIn) throws SystemException;

}
