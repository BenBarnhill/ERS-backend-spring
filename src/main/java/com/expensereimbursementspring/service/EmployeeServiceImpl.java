package com.expensereimbursementspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementspring.dao.EmployeeDao;
import com.expensereimbursementspring.entities.EmployeeEntity;
import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.pojo.UserPojo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao empDao;

	@Override
	public EmployeePojo fetchEmployee(int empId) {
		Optional<EmployeeEntity> optional = empDao.findById(empId);
		EmployeePojo empPojo = null;
		if(optional.isPresent()) {
			EmployeeEntity empEntity = optional.get();
			empPojo = new EmployeePojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
		}
		return empPojo;
	}

	@Override
	public EmployeePojo loginEmployee(EmployeePojo pojoIn) {
		EmployeePojo loginPojo = new EmployeePojo(0, "","","",0,"","","");
		EmployeeEntity empEntity = empDao.findEmployeeByEmail(pojoIn.getEmpEmail());
		EmployeePojo fetchedPojo = new EmployeePojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
		if(fetchedPojo.getEmpPassword().equals(pojoIn.getEmpPassword())) {
			loginPojo = fetchedPojo;
		}
		return loginPojo;
	}

	@Override
	public List<EmployeePojo> fetchAllEmployees() {
		List<EmployeePojo> allEmpPojos = new ArrayList<EmployeePojo>();
		List<EmployeeEntity> allEmployeeEntities = empDao.findAll();
		for(EmployeeEntity empEntity: allEmployeeEntities) {
			EmployeePojo empPojo = new EmployeePojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
			allEmpPojos.add(empPojo);
		}
		return allEmpPojos;
	}

	@Override
	public EmployeePojo updateInfo(EmployeePojo userPojo) {
		Optional<EmployeeEntity> optional = empDao.findById(userPojo.getEmpId());
		EmployeePojo updatedPojo = null;
		if(optional.isPresent()) {
			EmployeeEntity empEntity = optional.get();
			empEntity.setEmpPassword(userPojo.getEmpPassword());
			empEntity.setEmpFirstName(userPojo.getEmpFirstName());
			empEntity.setEmpLastName(userPojo.getEmpLastName());
			empEntity.setEmpContact(userPojo.getEmpContact());
			empEntity.setEmpEmail(userPojo.getEmpEmail());
			empEntity.setEmpAddress(userPojo.getEmpAddress());
			empDao.saveAndFlush(empEntity);
			
			updatedPojo = new EmployeePojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
		}
		return updatedPojo;
	}

}
