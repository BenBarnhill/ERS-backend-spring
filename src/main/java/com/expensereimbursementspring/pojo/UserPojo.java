package com.expensereimbursementspring.pojo;

public class UserPojo {
	
	private int userId;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private long userContact;
	private String userEmail;
	private String userAddress;
	private String userRole;
	
	public UserPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPojo(int userId, String userPassword, String userFirstName, String userLastName, long userContact,
			String userEmail, String userAddress, String userRole) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userContact = userContact;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userPassword=" + userPassword + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userContact=" + userContact + ", userEmail=" + userEmail
				+ ", userAddress=" + userAddress + ", userRole=" + userRole + "]";
	}
	

}
