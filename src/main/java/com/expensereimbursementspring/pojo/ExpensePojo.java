package com.expensereimbursementspring.pojo;

public class ExpensePojo {

	private int expenseId;
	private int expenseRequest;
	private double expenseAmount;
	private String expenseReason;
	private String expenseCreated;
	private String expenseResolved;
	private int expenseResponse;
	private String expenseStatus;
	
	public ExpensePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpensePojo(int expenseId, int expenseRequest, double expenseAmount, String expenseReason,
			String expenseCreated, String expenseResolved, int expenseResponse, String expenseStatus) {
		super();
		this.expenseId = expenseId;
		this.expenseRequest = expenseRequest;
		this.expenseAmount = expenseAmount;
		this.expenseReason = expenseReason;
		this.expenseCreated = expenseCreated;
		this.expenseResolved = expenseResolved;
		this.expenseResponse = expenseResponse;
		this.expenseStatus = expenseStatus;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public int getExpenseRequest() {
		return expenseRequest;
	}

	public void setExpenseRequest(int expenseRequest) {
		this.expenseRequest = expenseRequest;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getExpenseReason() {
		return expenseReason;
	}

	public void setExpenseReason(String expenseReason) {
		this.expenseReason = expenseReason;
	}

	public String getExpenseCreated() {
		return expenseCreated;
	}

	public void setExpenseCreated(String expenseCreated) {
		this.expenseCreated = expenseCreated;
	}

	public String getExpenseResolved() {
		return expenseResolved;
	}

	public void setExpenseResolved(String expenseResolved) {
		this.expenseResolved = expenseResolved;
	}

	public int getExpenseResponse() {
		return expenseResponse;
	}

	public void setExpenseResponse(int expenseResponse) {
		this.expenseResponse = expenseResponse;
	}

	public String getExpenseStatus() {
		return expenseStatus;
	}

	public void setExpenseStatus(String expenseStatus) {
		this.expenseStatus = expenseStatus;
	}

	@Override
	public String toString() {
		return "ExpensePojo [expenseId=" + expenseId + ", expenseRequest=" + expenseRequest + ", expenseAmount="
				+ expenseAmount + ", expenseReason=" + expenseReason + ", expenseCreated=" + expenseCreated
				+ ", expenseResolved=" + expenseResolved + ", expenseResponse=" + expenseResponse + ", expenseStatus="
				+ expenseStatus + "]";
	}
}
