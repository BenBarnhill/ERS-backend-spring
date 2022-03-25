package com.expensereimbursementspring.service;

import java.util.List;

import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.FinalExpensesPojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;

public interface FinalExpensesService {

	List<ExpensePojo> fetchAllFinalExpenses() throws SystemException;
	
	FinalExpensesPojo approveExpense(PendingExpensesPojo pendPojo) throws SystemException;
	
	FinalExpensesPojo denyExpense(PendingExpensesPojo pendPojo) throws SystemException;
	
	List<ExpensePojo> fetchEmployeeFinalExpenses(int empId) throws SystemException;
	
	List<ExpensePojo> fetchAllEmployeeExpenses(int empId) throws SystemException;
}
