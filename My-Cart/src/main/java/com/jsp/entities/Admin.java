package com.jsp.entities;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(length = 100, name = "user_name")
	private String userName;
	@Column(length = 70, name = "user_email",unique = true)
	private String userEmail;
	@Column(length = 90, name = "user_password")
	private String userPassword;
	@Column(name = "user_phone")
	private String userPhone;
	@Column(length = 100, name = "user_admin")
	private String userType;
	
	@OneToMany
	private List<Merchant> merchant;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public List<Merchant> getMerchant() {
		return merchant;
	}
	public void setMerchant(List<Merchant> merchant) {
		this.merchant = merchant;
	}
	
	public Admin(String userName, String userEmail, String userPassword, String userPhone,
			String userType, List<Merchant> merchant) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userType = userType;
		this.merchant = merchant;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
		super();
	}	
}
