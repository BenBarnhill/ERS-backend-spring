package com.expensereimbursementspring.service;

import java.util.List;

import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.FinalExpensesPojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;

public interface FinalExpensesService {

	List<ExpensePojo> fetchAllFinalExpenses();
	
	FinalExpensesPojo approveExpense(PendingExpensesPojo pendPojo);
	
	FinalExpensesPojo denyExpense(PendingExpensesPojo pendPojo);
	
	List<ExpensePojo> fetchEmployeeFinalExpenses(int empId);
}
