package com.expensereimbursementspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_deatils")
public class AdminEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	private int adminId;
	
	@Column(name="admin_password")
	private String adminPassword;
	
	@Column(name="admin_first_name")
	private String adminFirstName;
	
	@Column(name="admin_last_name")
	private String adminLastName;
	
	@Column(name="admin_contact")
	private long adminContact;
	
	@Column(name="admin_email")
	private String adminEmail;
	
	@Column(name="admin_address")
	private String adminAddress;
	
	@Column(name="admin_role")
	private String adminRole;

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEntity(int adminId, String adminPassword, String adminFirstName, String adminLastName,
			long adminContact, String adminEmail, String adminAddress, String adminRole) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
		this.adminAddress = adminAddress;
		this.adminRole = adminRole;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public long getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(long adminContact) {
		this.adminContact = adminContact;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminFirstName="
				+ adminFirstName + ", adminLastName=" + adminLastName + ", adminContact=" + adminContact
				+ ", adminEmail=" + adminEmail + ", adminAddress=" + adminAddress + ", adminRole=" + adminRole + "]";
	}
	
	

}
