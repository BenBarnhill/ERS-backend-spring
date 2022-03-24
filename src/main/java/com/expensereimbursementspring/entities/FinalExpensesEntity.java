package com.expensereimbursementspring.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;
import org.hibernate.tuple.GenerationTiming;

@Entity
@Table(name="reimbursements_final")
public class FinalExpensesEntity {
	
	@Id
	@Column(name="final_id")
	private int finalId;
	
	@ManyToOne
	@JoinColumn(name="final_request")
	private EmployeeEntity finalEmp;
	
	@Column(name="final_amount")
	private double finalAmount;
	
	@Column(name="final_reason")
	private String finalReason;
	
	@Column(name="final_request_time")
	private String finalRequest;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="final_resolve_time")
	private Timestamp finalResolved;
	
	@ManyToOne
	@JoinColumn(name="final_response")
	private AdminEntity finalAdmin;
	
	@Column(name="final_status")
	private String finalStatus;

	public FinalExpensesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinalExpensesEntity(int finalId, EmployeeEntity finalEmp, double finalAmount, String finalReason,
			String finalRequest, Timestamp finalResolved, AdminEntity finalAdmin, String finalStatus) {
		super();
		this.finalId = finalId;
		this.finalEmp = finalEmp;
		this.finalAmount = finalAmount;
		this.finalReason = finalReason;
		this.finalRequest = finalRequest;
		this.finalResolved = finalResolved;
		this.finalAdmin = finalAdmin;
		this.finalStatus = finalStatus;
	}

	public int getFinalId() {
		return finalId;
	}

	public void setFinalId(int finalId) {
		this.finalId = finalId;
	}

	public EmployeeEntity getFinalEmp() {
		return finalEmp;
	}

	public void setFinalEmp(EmployeeEntity finalEmp) {
		this.finalEmp = finalEmp;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public String getFinalReason() {
		return finalReason;
	}

	public void setFinalReason(String finalReason) {
		this.finalReason = finalReason;
	}

	public String getFinalRequest() {
		return finalRequest;
	}

	public void setFinalRequest(String finalRequest) {
		this.finalRequest = finalRequest;
	}

	public Timestamp getFinalResolved() {
		return finalResolved;
	}

	public void setFinalResolved(Timestamp finalResolved) {
		this.finalResolved = finalResolved;
	}

	public AdminEntity getFinalAdmin() {
		return finalAdmin;
	}

	public void setFinalAdmin(AdminEntity finalAdmin) {
		this.finalAdmin = finalAdmin;
	}

	public String getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}

	@Override
	public String toString() {
		return "FinalExpensesEntity [finalId=" + finalId + ", finalEmp=" + finalEmp + ", finalAmount=" + finalAmount
				+ ", finalReason=" + finalReason + ", finalRequest=" + finalRequest + ", finalResolved=" + finalResolved
				+ ", finalAdmin=" + finalAdmin + ", finalStatus=" + finalStatus + "]";
	}

	

	

}
