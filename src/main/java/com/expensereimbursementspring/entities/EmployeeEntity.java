package com.expensereimbursementspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_password")
	private String empPassword;
	
	@Column(name="emp_first_name")
	private String empFirstName;
	
	@Column(name="emp_last_name")
	private String empLastName;
	
	@Column(name="emp_contact")
	private long empContact;
	
	@Column(name="emp_email")
	private String empEmail;
	
	@Column(name="emp_address")
	private String empAddress;
	
	@ManyToOne
	@JoinColumn(name="emp_admin")
	private AdminEntity empAdmin;
	
	@Column(name="emp_role")
	private String empRole;

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(int empId, String empPassword, String empFirstName, String empLastName, long empContact,
			String empEmail, String empAddress, String empRole) {
		super();
		this.empId = empId;
		this.empPassword = empPassword;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empContact = empContact;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
		this.empRole = empRole;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public long getEmpContact() {
		return empContact;
	}

	public void setEmpContact(long empContact) {
		this.empContact = empContact;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", empPassword=" + empPassword + ", empFirstName=" + empFirstName
				+ ", empLastName=" + empLastName + ", empContact=" + empContact + ", empEmail=" + empEmail
				+ ", empAddress=" + empAddress + ", empRole=" + empRole + "]";
	}
	
	
	
	

}
