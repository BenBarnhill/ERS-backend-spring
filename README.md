# Expense Reimbursement System

## Project Description
This project is an extension of the previous Expense Reimbursement System with added functionalities, technologies, and microservices. In addition to submitting reimbursement requests, as they could before, the employees will now also be able to upload an image file as proof of their expenditure which can later be viewed by the admins when approving or denying a request. The framework used for this project was changed from Javalin to Spring Boot and microservices such as Jenkins, AWS, and Docker were used to host publicly deploy the backend and frontend. 

## Features
- As an employee, a user can:
  - Login
  - View the employee homepage
  - Logout
  - Submit a reimbursement request
  - Submit a receipt for approval
  - View their pending reimbursement requests
  - View their resolved reimbursement requests
  - View their information
  - Update their information
- As an admin, a user can:
  - Login
  - View the manager home page
  - Logout
  - Approve/Deny pending reimbursements requests
  - View submitted receipts
  - View all pending requests of all employees
  - View all resolved requests of all employees
  - View reimbursement requests of a specific employee
  - View all employees

## Technologies Used
JUnit, PostgreSQL, Spring Boot, Angular 2+, Java, TypeScript, Spring Framework, DevOps, Spring Data

## To-Do List
1. Utilize ORM through Spring Data in a more meaninful way, implement nested entities.
2. Implement more testing through Mockito to cover more functionalities.
3. Change schema to store file information in a more meaningful way.
4. Create and implement more custom exceptions.
5. Add a properties table to obsfuscate user credentials within PostgreSQL.
