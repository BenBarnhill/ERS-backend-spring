package com.expensereimbursementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.FinalExpensesPojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;
import com.expensereimbursementspring.service.FinalExpensesService;

@RestController
@CrossOrigin
@RequestMapping("api/resolutions")
public class FinalExpensesController {
	
	@Autowired
	FinalExpensesService finalService;
	
	@GetMapping("/")
	List<ExpensePojo> fetchAllFinalExpenses(){
		return finalService.fetchAllFinalExpenses();
	}
	
	@PostMapping("/approve")
	FinalExpensesPojo approveExpense(@RequestBody PendingExpensesPojo pendPojo) {
		return finalService.approveExpense(pendPojo);
	}
	
	@PostMapping("/deny")
	FinalExpensesPojo denyExpense(@RequestBody PendingExpensesPojo pendPojo) {
		return finalService.denyExpense(pendPojo);
	}
	
	@GetMapping("/final/{eid}")
	List<ExpensePojo> fetchEmployeeFinalExpenses(@PathVariable int eid){
		return finalService.fetchEmployeeFinalExpenses(eid);
	}
	
	@GetMapping("/all/{eid}")
	List<ExpensePojo> fetchAllEmployeeExpenses(@PathVariable int eid){
		return finalService.fetchAllEmployeeExpenses(eid);
	}
	

}
