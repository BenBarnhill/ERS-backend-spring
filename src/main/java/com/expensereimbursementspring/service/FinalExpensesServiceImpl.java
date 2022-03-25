package com.expensereimbursementspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expensereimbursementspring.dao.EmployeeDao;
import com.expensereimbursementspring.dao.FinalExpensesDao;
import com.expensereimbursementspring.dao.PendingExpensesDao;
import com.expensereimbursementspring.entities.EmployeeEntity;
import com.expensereimbursementspring.entities.FinalExpensesEntity;
import com.expensereimbursementspring.entities.PendingExpensesEntity;
import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.FinalExpensesPojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FinalExpensesServiceImpl implements FinalExpensesService {

	@Autowired
	FinalExpensesDao finalDao;
	
	@Autowired
	PendingExpensesDao pendDao;
	
	@Autowired
	EmployeeDao empDao;
	
	@Override
	public List<ExpensePojo> fetchAllFinalExpenses() throws SystemException{
		log.info("Entered fetchAllFinalExpenses of FinalExpensesService");
		List<ExpensePojo> allFinalExpenses = new ArrayList<ExpensePojo>();
		List<FinalExpensesEntity> allFinalEntities = finalDao.findAll();
		for(FinalExpensesEntity finalEntity: allFinalEntities) {
			ExpensePojo finalPojo = new ExpensePojo(finalEntity.getFinalId(), finalEntity.getFinalEmp().getEmpFirstName(), finalEntity.getFinalAmount(), finalEntity.getFinalReason(), finalEntity.getFinalRequest(), finalEntity.getFinalResolved().toString(), finalEntity.getFinalAdmin().getAdminFirstName(), finalEntity.getFinalStatus());
			allFinalExpenses.add(finalPojo);
		}
		log.info("Exited fetchAllFinalExpenses of FinalExpensesService");
		return allFinalExpenses;
	}

	@Override
	@Transactional
	public FinalExpensesPojo approveExpense(PendingExpensesPojo pendPojo) throws SystemException{
		log.info("Entered approveExpense of FinalExpensesService");
		Optional<PendingExpensesEntity> optional = pendDao.findById(pendPojo.getPendingId());
		FinalExpensesPojo finalPojo = null;
		String status = "APPROVED";
		if(optional.isPresent()) {
			PendingExpensesEntity pendEntity = optional.get();
			FinalExpensesEntity finalEntity = new FinalExpensesEntity(pendEntity.getPendId(), pendEntity.getPendEmp(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated().toString(), null, pendEntity.getPendAdmin(), status);
			finalDao.saveAndFlush(finalEntity);
			pendDao.deleteById(pendEntity.getPendId());
			
			finalPojo = new FinalExpensesPojo(finalEntity.getFinalId(), finalEntity.getFinalEmp().getEmpId(), finalEntity.getFinalAmount(), finalEntity.getFinalReason(), finalEntity.getFinalRequest(), finalEntity.getFinalResolved(), finalEntity.getFinalAdmin().getAdminId(), finalEntity.getFinalStatus());
		}
		log.info("Exited approveExpense of FinalExpensesService");
		return finalPojo;
	}

	@Override
	public FinalExpensesPojo denyExpense(PendingExpensesPojo pendPojo) throws SystemException{
		log.info("Entered denyExpense of FinalExpensesService");
		Optional<PendingExpensesEntity> optional = pendDao.findById(pendPojo.getPendingId());
		FinalExpensesPojo finalPojo = null;
		String status = "DENIED";
		if(optional.isPresent()) {
			PendingExpensesEntity pendEntity = optional.get();
			FinalExpensesEntity finalEntity = new FinalExpensesEntity(pendEntity.getPendId(), pendEntity.getPendEmp(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated().toString(), null, pendEntity.getPendAdmin(), status);
			finalDao.saveAndFlush(finalEntity);
			pendDao.deleteById(pendEntity.getPendId());
			
			finalPojo = new FinalExpensesPojo(finalEntity.getFinalId(), finalEntity.getFinalEmp().getEmpId(), finalEntity.getFinalAmount(), finalEntity.getFinalReason(), finalEntity.getFinalRequest(), finalEntity.getFinalResolved(), finalEntity.getFinalAdmin().getAdminId(), finalEntity.getFinalStatus());
		}
		log.info("Exited denyExpense of FinalExpensesService");
		return finalPojo;
	}

	@Override
	public List<ExpensePojo> fetchEmployeeFinalExpenses(int empId) throws SystemException{
		log.info("Entered fetchEmployeeFinalExpenses of FinalExpensesService");
		List<ExpensePojo> allFinalExpenses = new ArrayList<ExpensePojo>();
		Optional<EmployeeEntity> optional = empDao.findById(empId);
		EmployeeEntity empEntity = null;
		if(optional.isPresent()) {
			empEntity = optional.get();
		}
		List<FinalExpensesEntity> allEmpFinalEntities = finalDao.findByFinalEmp(empEntity);
		for(FinalExpensesEntity finalEntity: allEmpFinalEntities) {
			ExpensePojo finalPojo = new ExpensePojo(finalEntity.getFinalId(), finalEntity.getFinalEmp().getEmpFirstName(), finalEntity.getFinalAmount(), finalEntity.getFinalReason(), finalEntity.getFinalRequest(), finalEntity.getFinalResolved().toString(), finalEntity.getFinalAdmin().getAdminFirstName(), finalEntity.getFinalStatus());
			allFinalExpenses.add(finalPojo);
		}
		log.info("Exited fetchEmployeeFinalExpenses of FinalExpensesService");
		return allFinalExpenses;
	}

	@Override
	public List<ExpensePojo> fetchAllEmployeeExpenses(int empId) throws SystemException{
		log.info("Entered fetchAllEmployeeExpenses of FinalExpensesService");
		List<ExpensePojo> allEmployeeExpenses = new ArrayList<ExpensePojo>();
		Optional<EmployeeEntity> optional = empDao.findById(empId);
		EmployeeEntity empEntity = null;
		if(optional.isPresent()) {
			empEntity = optional.get();
		}
		List<PendingExpensesEntity> allEmpPendingEntities = pendDao.findByPendEmp(empEntity);
		for(PendingExpensesEntity pendEntity: allEmpPendingEntities) {
			ExpensePojo pendPojo = new ExpensePojo(pendEntity.getPendId(), pendEntity.getPendEmp().getEmpFirstName(), pendEntity.getPendAmount(), pendEntity.getPendReason(), pendEntity.getPendCreated().toString(), pendEntity.getPendResolved(), pendEntity.getPendAdmin().getAdminFirstName(), pendEntity.getPendStatus());
			allEmployeeExpenses.add(pendPojo);
		}
		List<FinalExpensesEntity> allEmpFinalEntities = finalDao.findByFinalEmp(empEntity);
		for(FinalExpensesEntity finalEntity: allEmpFinalEntities) {
			ExpensePojo finalPojo = new ExpensePojo(finalEntity.getFinalId(), finalEntity.getFinalEmp().getEmpFirstName(), finalEntity.getFinalAmount(), finalEntity.getFinalReason(), finalEntity.getFinalRequest(), finalEntity.getFinalResolved().toString(), finalEntity.getFinalAdmin().getAdminFirstName(), finalEntity.getFinalStatus());
			allEmployeeExpenses.add(finalPojo);
		}
		log.info("Exited fetchAllEmployeeExpenses of FinalExpensesService");
		return allEmployeeExpenses;
	}

}
