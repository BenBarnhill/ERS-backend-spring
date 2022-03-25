package com.expensereimbursementspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.expensereimbursementspring.controller.EmployeeController;
import com.expensereimbursementspring.dao.EmployeeDao;
import com.expensereimbursementspring.entities.EmployeeEntity;
import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.EmployeePojo;
import com.expensereimbursementspring.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@ExtendWith(MockitoExtension.class)
@SpringBootTest//This ensures that we are test the methods within mockito and not the web server
public class JUnitoMockitoTesting {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeDao employeeDao;
	
	
	@InjectMocks
	private EmployeeController employeeController;

	EmployeePojo employee_1 = new EmployeePojo(1, "123", "Justin", "Green", 777444222, "Jg@gmail.com", "123 Highway Lane", "Employee");
	EmployeePojo employee_2 = new EmployeePojo(2, "123", "Nelly", "Stephans", 777444222, "Ns@gmail.com", "123 Highway Lane", "Employee");
	EmployeePojo employee_3 = new EmployeePojo(3, "123", "Sara", "Craft", 777444222, "Sc@gmail.com", "123 Highway Lane", "Employee");
	
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		//initializes Mockito inside a class as boilerplate code
	}
	
	@Test
	public void getAllEmployeesTest()
	{
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		EmployeePojo employee_1 = new EmployeePojo(1, "123", "Justin", "Green", 777444222, "Jg@gmail.com", "123 Highway Lane", "Employee");
		EmployeePojo employee_2 = new EmployeePojo(2, "123", "Nelly", "Stephans", 777444222, "Ns@gmail.com", "123 Highway Lane", "Employee");
		EmployeePojo employee_3 = new EmployeePojo(3, "123", "Sara", "Craft", 777444222, "Sc@gmail.com", "123 Highway Lane", "Employee");

		list.add(employee_1);
		list.add(employee_1);
		list.add(employee_1);

		try {
			when(employeeService.fetchAllEmployees()).thenReturn(list);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		//Mockito.when(employeeService.fetchAllEmployees()).thenReturn(employees);
		
		//get request via endpoint test
		//mockMvc.perform(MockMvcRequestBuilders.get("/{eid}"))
		//.contentType(MediaType.APPLICATION_JSON))
        //.andExpect(status().isOk())
        //.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
        //.andExpect(jsonPath("$[2].empPassword", is("123")));
	}
	
	@Test
	public void fetchEmployee_success() throws Exception {
		Mockito.when(employeeService.fetchEmployee(employee_1.getEmpId())).thenReturn((employee_1));
		
		//get request via endpoint test
				//mockMvc.perform(MockMvcRequestBuilders.get("/emp1"))
				//.contentType(MediaType.APPLICATION_JSON))
		        //.andExpect(status().isOk())
		        //.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
		        //.andExpect(jsonPath("$[2].empPassword", is("123")));
	}
	
	@Test
	public void fetchEmployeeTest() {
		try {
			when(employeeDao.findById(2)).thenReturn(
					Optional.of(new EmployeeEntity(1, "123", "Justin", "Green", 777444222, "Jg@gmail.com", "123 Highway Lane", "Employee")));
			EmployeePojo actualResult = employeeService.fetchEmployee(2);
			EmployeePojo expectedResult = new EmployeePojo(1, "123", "Justin", "Green", 777444222, "Jg@gmail.com", "123 Highway Lane", "Employee");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}
	
	@Test
	public void login_success() throws Exception {
		Mockito.when(employeeService.loginEmployee(employee_1)).thenReturn((employee_1));
	}
	
	
	

}