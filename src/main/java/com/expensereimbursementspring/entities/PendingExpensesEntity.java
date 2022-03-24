package com.expensereimbursementspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="reimbursements_pending")
public class PendingExpensesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pend_id")
	private int pendId;
	
	@ManyToOne
	@JoinColumn(name = "pend_request")
	private EmployeeEntity pendEmp;
	
	@Column(name = "pend_amount")
	private double pendAmount;
	
	@Column(name = "pend_reason")
	private String pendReason;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pend_request_time")
	private String pendCreated;
	
	@Column(name = "pend_resolve_time")
	private String pendResolved;

	@ManyToOne
	@JoinColumn(name = "pend_response")
	private AdminEntity pendAdmin;
	
	@Value(value = "PENDING")
	@Column(name = "pend_status")
	private String pendStatus;

	public PendingExpensesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PendingExpensesEntity(int pendId, EmployeeEntity pendEmp, double pendAmount, String pendReason,
			String pendCreated, String pendResolved, AdminEntity pendAdmin, String pendStatus) {
		super();
		this.pendId = pendId;
		this.pendEmp = pendEmp;
		this.pendAmount = pendAmount;
		this.pendReason = pendReason;
		this.pendCreated = pendCreated;
		this.pendResolved = pendResolved;
		this.pendAdmin = pendAdmin;
		this.pendStatus = pendStatus;
	}

	public int getPendId() {
		return pendId;
	}

	public void setPendId(int pendId) {
		this.pendId = pendId;
	}

	public EmployeeEntity getPendEmp() {
		return pendEmp;
	}

	public void setPendEmp(EmployeeEntity pendEmp) {
		this.pendEmp = pendEmp;
	}

	public double getPendAmount() {
		return pendAmount;
	}

	public void setPendAmount(double pendAmount) {
		this.pendAmount = pendAmount;
	}

	public String getPendReason() {
		return pendReason;
	}

	public void setPendReason(String pendReason) {
		this.pendReason = pendReason;
	}

	public String getPendCreated() {
		return pendCreated;
	}

	public void setPendCreated(String pendCreated) {
		this.pendCreated = pendCreated;
	}

	public String getPendResolved() {
		return pendResolved;
	}

	public void setPendResolved(String pendResolved) {
		this.pendResolved = pendResolved;
	}

	public AdminEntity getPendAdmin() {
		return pendAdmin;
	}

	public void setPendAdmin(AdminEntity pendAdmin) {
		this.pendAdmin = pendAdmin;
	}

	public String getPendStatus() {
		return pendStatus;
	}

	public void setPendStatus(String pendStatus) {
		this.pendStatus = pendStatus;
	}

	@Override
	public String toString() {
		return "PendingExpensesEntity [pendId=" + pendId + ", pendEmp=" + pendEmp + ", pendAmount=" + pendAmount
				+ ", pendReason=" + pendReason + ", pendCreated=" + pendCreated
				+ ", pendResolved=" + pendResolved + ", pendAdmin=" + pendAdmin + ", pendStatus=" + pendStatus + "]";
	}
	

}
