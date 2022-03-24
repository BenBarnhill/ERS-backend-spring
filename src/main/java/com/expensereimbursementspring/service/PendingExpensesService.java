package com.expensereimbursementspring.service;

import java.util.List;

import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;

public interface PendingExpensesService {
	
	PendingExpensesPojo fetchPendingExpense(int expenseId);
	
	List<ExpensePojo> fetchAllPendingExpenses();
	
	List<ExpensePojo> fetchEmployeePendingExpenses(int empId);
	
	PendingExpensesPojo submitRequest(PendingExpensesPojo pendPojo);

	long pendingAmount();
}
