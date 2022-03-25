package com.expensereimbursementspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementspring.dao.EmployeeDao;
import com.expensereimbursementspring.entities.EmployeeEntity;
import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.pojo.UserPojo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao empDao;

	@Override
	public EmployeePojo fetchEmployee(int empId) throws SystemException{
		log.info("Entered in fetchEmployee of EmployeeService");
		Optional<EmployeeEntity> optional = empDao.findById(empId);
		EmployeePojo empPojo = null;
		if(optional.isPresent()) {
			EmployeeEntity empEntity = optional.get();
			empPojo = new EmployeePojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
		}
		log.info("Exited fetchEmployee of EmployeeService");
		return empPojo;
	}

	@Override
	public EmployeePojo loginEmployee(EmployeePojo pojoIn) throws SystemException{
		log.info("Entered in loginEmployee of EmployeeService");
		EmployeePojo loginPojo = new EmployeePojo(0, "","","",0,"","","");
		EmployeeEntity empEntity = empDao.findByEmpEmail(pojoIn.getEmpEmail());
		EmployeePojo fetchedPojo = new EmployeePojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
		if(fetchedPojo.getEmpPassword().equals(pojoIn.getEmpPassword())) {
			loginPojo = fetchedPojo;
		}
		log.info("Exited loginEmployee of EmployeeService");
		return loginPojo;
	}

	@Override
	public List<EmployeePojo> fetchAllEmployees() throws SystemException{
		log.info("Entered in fetchAllEmployees of EmployeeService");
		List<EmployeePojo> allEmpPojos = new ArrayList<EmployeePojo>();
		List<EmployeeEntity> allEmployeeEntities = empDao.findAll();
		for(EmployeeEntity empEntity: allEmployeeEntities) {
			EmployeePojo empPojo = new EmployeePojo(empEntity.getEmpId(), empEntity.getEmpPassword(), empEntity.getEmpFirstName(), empEntity.getEmpLastName(), empEntity.getEmpContact(), empEntity.getEmpEmail(), empEntity.getEmpAddress(), empEntity.getEmpRole());
			allEmpPojos.add(empPojo);
		}
		log.info("Exited fetchAllEmployees of EmployeeService");
		return allEmpPojos;
	}

	@Override
	public EmployeePojo updateInfo(EmployeePojo userPojo) throws SystemException{
		log.info("Entered in updateInfo of EmployeeService");
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
		log.info("Exited updateInfo of EmployeeService");
		return updatedPojo;
	}

}
