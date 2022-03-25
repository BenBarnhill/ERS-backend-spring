package com.expensereimbursementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.ExpensePojo;
import com.expensereimbursementspring.pojo.PendingExpensesPojo;
import com.expensereimbursementspring.service.PendingExpensesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
public class PendingExpensesController {
	
	@Autowired
	PendingExpensesService pendService;
	
	@GetMapping("/requests/{pid}")
	PendingExpensesPojo fetchPendingExpense(@PathVariable int pid) throws SystemException{
		log.info("Entered fetchPendingExpense of PendingExpensesController");
		return pendService.fetchPendingExpense(pid);
	}
	
	@GetMapping("/requests")
	List<ExpensePojo> fetchAllPendingExpenses() throws SystemException{
		log.info("Entered fetchAllPendingExpenses of PendingExpensesController");
		return pendService.fetchAllPendingExpenses();
	}
	
	@GetMapping("/pendings/{eid}")
	List<ExpensePojo> fetchEmployeePendingExpenses(@PathVariable int eid) throws SystemException{
		log.info("Entered fetchEmployeePendingExpenses of PendingExpensesController");
		return pendService.fetchEmployeePendingExpenses(eid);
	}
	
	@GetMapping("/amounts")
	long pendingAmount() throws SystemException{
		log.info("Entered pendingAmount of PendingExpensesController");
		return pendService.pendingAmount();
	}
	
	@RequestMapping(value="/submit", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	PendingExpensesPojo  submitRequest(@RequestBody PendingExpensesPojo pendPojo) throws SystemException{
		log.info("Entered submitRequest of PendingExpensesController");
		return pendService.submitRequest(pendPojo);
	}
	
	

}
