package com.expensereimbursementspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensereimbursementspring.entities.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{

	// SELECT * FROM employee_details WHERE emp_email=userEmail;
	EmployeeEntity findEmployeeByEmail(String empEmail);
}
