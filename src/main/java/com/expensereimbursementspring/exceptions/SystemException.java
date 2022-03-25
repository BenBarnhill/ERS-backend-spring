package com.expensereimbursementspring.exceptions;

public class SystemException extends Exception {

	@Override
	public String getMessage() {
		return "The application has encountered an error. Please try again later.";
	}

	
}
