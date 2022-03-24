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
import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;

@Service
public class PendingExpensesServiceImpl implements PendingExpensesService {

	@Autowired
	PendingExpensesDao pendDao;
	
	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public PendingExpensesPojo fetchPendingExpense(int expenseId) {
		Optional<PendingExpensesEntity> optional = pendDao.findById(expenseId);
		PendingExpensesPojo pendPojo = null;
		if(optional.isPresent()) {
			PendingExpensesEntity pendEntity = optional.get();
			pendPojo = new PendingExpensesPojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpId(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminId(), pendEntity.getPendStatus());
		}
		return pendPojo;
	}

	@Override
	public List<ExpensePojo> fetchAllPendingExpenses() {
		List<ExpensePojo> allPendExpenses = new ArrayList<ExpensePojo>();
		List<PendingExpensesEntity> allPendEntities = pendDao.findAll();
		for(PendingExpensesEntity pendEntity: allPendEntities) {
			ExpensePojo pendPojo = new ExpensePojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpFirstName(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminFirstName(), pendEntity.getPendStatus());
			allPendExpenses.add(pendPojo);
		}
		return allPendExpenses;
	}

	@Override
	public List<ExpensePojo> fetchEmployeePendingExpenses(int empId) {
		List<ExpensePojo> allPendExpenses = new ArrayList<ExpensePojo>();
		List<PendingExpensesEntity> allEmpPendEntities = pendDao.findByEmpId(empId);
		for(PendingExpensesEntity pendEntity: allEmpPendEntities) {
			ExpensePojo pendPojo = new ExpensePojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpFirstName(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminFirstName(), pendEntity.getPendStatus());
			allPendExpenses.add(pendPojo);
		}
		return allPendExpenses;
	}

	@Override
	public PendingExpensesPojo submitRequest(PendingExpensesPojo pendPojo) {
		Optional<EmployeeEntity> optional = empDao.findById(pendPojo.getPendingRequest());
		PendingExpensesPojo submitPojo = null;
		if(optional.isPresent()) {
			EmployeeEntity empEntity = optional.get();
			Optional<AdminEntity> optional2 = adminDao.findById(1);
			if(optional2.isPresent()) {
				AdminEntity adminEntity = optional2.get();
				PendingExpensesEntity pendEntity = new PendingExpensesEntity(pendPojo.getPendingId(), empEntity, pendPojo.getPendingAmount(), pendPojo.getPendingReason(), pendPojo.getPendingCreated(), pendPojo.getPendingResolved(), adminEntity, pendPojo.getPendingStatus());
				pendDao.saveAndFlush(pendEntity);
				submitPojo = new PendingExpensesPojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpId(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminId(), pendEntity.getPendStatus());
			}
			
		}
		return submitPojo;
	}
	
	@Override
	public long pendingAmount() {
		long pendNum = pendDao.count();
		return pendNum;
	}

}
