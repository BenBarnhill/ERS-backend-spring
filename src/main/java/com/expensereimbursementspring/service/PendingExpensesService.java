package com.expensereimbursementspring.service;

import java.util.List;

import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;

public interface PendingExpensesService {
	
	PendingExpensesPojo fetchPendingExpense(int expenseId) throws SystemException;
	
	List<ExpensePojo> fetchAllPendingExpenses() throws SystemException;
	
	List<ExpensePojo> fetchEmployeePendingExpenses(int empId) throws SystemException;
	
	PendingExpensesPojo submitRequest(PendingExpensesPojo pendPojo) throws SystemException;

	long pendingAmount() throws SystemException;
}
