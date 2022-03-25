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

import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.FinalExpensesPojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;
import com.expensereimbursementspring.service.FinalExpensesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("api/resolutions")
@Slf4j
public class FinalExpensesController {
	
	@Autowired
	FinalExpensesService finalService;
	
	@GetMapping("/")
	List<ExpensePojo> fetchAllFinalExpenses() throws SystemException{
		log.info("Entered fetchAllFinalExpenses of FinalExpensesController");
		return finalService.fetchAllFinalExpenses();
	}
	
	@PostMapping("/approve")
	FinalExpensesPojo approveExpense(@RequestBody PendingExpensesPojo pendPojo) throws SystemException{
		log.info("Entered approveExpense of FinalExpensesController");
		return finalService.approveExpense(pendPojo);
	}
	
	@PostMapping("/deny")
	FinalExpensesPojo denyExpense(@RequestBody PendingExpensesPojo pendPojo) throws SystemException{
		log.info("Entered denyExpense of FinalExpensesController");
		return finalService.denyExpense(pendPojo);
	}
	
	@GetMapping("/final/{eid}")
	List<ExpensePojo> fetchEmployeeFinalExpenses(@PathVariable int eid) throws SystemException{
		log.info("Entered fetchEmployeeFinalExpenses of FinalExpensesController");
		return finalService.fetchEmployeeFinalExpenses(eid);
	}
	
	@GetMapping("/all/{eid}")
	List<ExpensePojo> fetchAllEmployeeExpenses(@PathVariable int eid) throws SystemException{
		log.info("Entered fetchAllEmployeesExpenses of FinalExpensesController");
		return finalService.fetchAllEmployeeExpenses(eid);
	}
	

}
