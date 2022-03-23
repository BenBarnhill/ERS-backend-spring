package com.expensereimbursementspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementspring.dao.EmployeeDao;
import com.expensereimbursementspring.entities.EmployeeEntity;
import com.expensereimbursementspring.pojo.UserPojo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao empDao;

	@Override
	public UserPojo fetchEmployee(int empId) {
		Optional<EmployeeEntity> optional = empDao.findById(empId);
		UserPojo userPojo = null;
		if(optional.isPresent()) {
			EmployeeEntity empEntity = optional.get();
			userPojo = new UserPojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
		}
		return userPojo;
	}

	@Override
	public UserPojo loginEmployee(UserPojo userIn) {
		UserPojo loginPojo = new UserPojo(0, "","","",0,"","","");
		EmployeeEntity empEntity = empDao.findEmployeeByEmail(userIn.getUserEmail());
		UserPojo fetchedPojo = new UserPojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
		if(fetchedPojo.getUserPassword().equals(userIn.getUserPassword())) {
			loginPojo = fetchedPojo;
		}
		return loginPojo;
	}

	@Override
	public List<UserPojo> fetchAllEmployees() {
		List<UserPojo> allUserPojos = new ArrayList<UserPojo>();
		List<EmployeeEntity> allEmployeeEntities = empDao.findAll();
		for(EmployeeEntity empEntity: allEmployeeEntities) {
			UserPojo userPojo = new UserPojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
			allUserPojos.add(userPojo);
		}
		return allUserPojos;
	}

	@Override
	public UserPojo updateInfo(UserPojo userPojo) {
		// TODO Auto-generated method stub
		return null;
	}

}
