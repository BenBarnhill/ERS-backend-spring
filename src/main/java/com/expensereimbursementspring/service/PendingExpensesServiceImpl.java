package com.expensereimbursementspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementspring.dao.AdminDao;
import com.expensereimbursementspring.dao.EmployeeDao;
import com.expensereimbursementspring.dao.PendingExpensesDao;
import com.expensereimbursementspring.entities.AdminEntity;
import com.expensereimbursementspring.entities.EmployeeEntity;
import com.expensereimbursementspring.entities.PendingExpensesEntity;
import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PendingExpensesServiceImpl implements PendingExpensesService {

	@Autowired
	PendingExpensesDao pendDao;
	
	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public PendingExpensesPojo fetchPendingExpense(int expenseId) throws SystemException{
		log.info("Entered fetchPendingExpense of PendingExpensesService");
		Optional<PendingExpensesEntity> optional = pendDao.findById(expenseId);
		PendingExpensesPojo pendPojo = null;
		if(optional.isPresent()) {
			PendingExpensesEntity pendEntity = optional.get();
			pendPojo = new PendingExpensesPojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpId(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated().toString(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminId(), pendEntity.getPendStatus());
		}
		log.info("Exited fetchPendingExpense of PendingExpensesService");
		return pendPojo;
	}

	@Override
	public List<ExpensePojo> fetchAllPendingExpenses() throws SystemException{
		log.info("Entered fetchAllPendingExpenses of PendingExpensesService");
		List<ExpensePojo> allPendExpenses = new ArrayList<ExpensePojo>();
		List<PendingExpensesEntity> allPendEntities = pendDao.findAll();
		for(PendingExpensesEntity pendEntity: allPendEntities) {
			ExpensePojo pendPojo = new ExpensePojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpFirstName(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated().toString(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminFirstName(), pendEntity.getPendStatus());
			allPendExpenses.add(pendPojo);
		}
		log.info("Exited fetchAllPendingExpenses of PendingExpensesService");
		return allPendExpenses;
	}

	@Override
	public List<ExpensePojo> fetchEmployeePendingExpenses(int empId) throws SystemException{
		log.info("Entered fetchEmployeePendingExpenses of PendingExpensesService");
		List<ExpensePojo> allPendExpenses = new ArrayList<ExpensePojo>();
		Optional<EmployeeEntity> optional = empDao.findById(empId);
		EmployeeEntity empEntity = null;
		if(optional.isPresent()) {
			empEntity = optional.get();
		}
		List<PendingExpensesEntity> allEmpPendEntities = pendDao.findByPendEmp(empEntity);
		for(PendingExpensesEntity pendEntity: allEmpPendEntities) {
			ExpensePojo pendPojo = new ExpensePojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpFirstName(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated().toString(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminFirstName(), pendEntity.getPendStatus());
			allPendExpenses.add(pendPojo);
		}
		log.info("Exited fetchEmployeePendingExpenses of PendingExpensesService");
		return allPendExpenses;
	}

	@Override
	public PendingExpensesPojo submitRequest(PendingExpensesPojo pendPojo) throws SystemException{
		log.info("Entered submitRequest of PendingExpensesService");
		Optional<EmployeeEntity> optional = empDao.findById(pendPojo.getPendingRequest());
		PendingExpensesPojo submitPojo = null;
		if(optional.isPresent()) {
			EmployeeEntity empEntity = optional.get();
			Optional<AdminEntity> optional2 = adminDao.findById(1);
			if(optional2.isPresent()) {
				AdminEntity adminEntity = optional2.get();
				PendingExpensesEntity pendEntity = new PendingExpensesEntity(pendPojo.getPendingId(), empEntity, pendPojo.getPendingAmount(), pendPojo.getPendingReason(), null, pendPojo.getPendingResolved(), adminEntity, "PENDING");
				pendDao.saveAndFlush(pendEntity);
				submitPojo = new PendingExpensesPojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpId(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated().toString(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminId(), pendEntity.getPendStatus());
			}
			
		}
		log.info("Exited submitPojo of PendingExpensesService");
		return submitPojo;
	}
	
	@Override
	public long pendingAmount() throws SystemException{
		log.info("Entered pendingAmount of PendingExpensesService");
		long pendNum = pendDao.count();
		log.info("Exited pendingAmount of PendingExpensesService");
		return pendNum;
	}

}
