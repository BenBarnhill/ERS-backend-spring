package com.expensereimbursementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;
import com.expensereimbursementspring.service.PendingExpensesService;

@RestController
@RequestMapping("/api")
public class PendingExpensesController {
	
	@Autowired
	PendingExpensesService pendService;
	
	@GetMapping("/requests/{pid}")
	PendingExpensesPojo fetchPendingExpense(@PathVariable int pid) {
		return pendService.fetchPendingExpense(pid);
	}
	
	@GetMapping("/requests")
	List<ExpensePojo> fetchAllPendingExpenses() {
		return pendService.fetchAllPendingExpenses();
	}
	
	@GetMapping("/pendings/{eid}")
	List<ExpensePojo> fetchEmployeePendingExpenses(@PathVariable int empId){
		return pendService.fetchEmployeePendingExpenses(empId);
	}
	
	@GetMapping("/amounts")
	long pendingAmount() {
		return pendService.pendingAmount();
	}
	
	

}
