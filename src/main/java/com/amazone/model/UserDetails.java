package com.amazone.model;

public class UserDetails {

	private String userId;
	private String userName;
	private String password;
	private String mailId;
	private Integer mobile;
	private String address;
	private Double wallet;
	
	public UserDetails(String userId, String userName, String password, String mailId, Integer mobile, String address,
			Double wallet) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mailId = mailId;
		this.mobile = mobile;
		this.address = address;
		this.wallet = wallet;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "UserDetails [userId =" + userId + ", userName =" + userName + ", password =" + password + ", mailId ="
				+ mailId + ", mobile =" + mobile + ", address =" + address + ", wallet =" + wallet + "]";
	}

	
	
}
