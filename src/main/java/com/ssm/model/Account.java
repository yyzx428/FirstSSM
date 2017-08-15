package com.ssm.model;

public class Account {
	private String userName;
	private String passWord;
	
	public void setUserName(String name) {
		userName=name;
	}
	
	public void setPassWord(String passWord) {
		this.passWord=passWord;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	@Override
	public String toString() {
		return "Account [userName="+userName+" passWord="+passWord+"]";
	}
}
