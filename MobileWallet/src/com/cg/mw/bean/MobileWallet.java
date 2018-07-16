package com.cg.mw.bean;

import java.time.LocalDate;

public class MobileWallet 
{
private String mobileNo;
private String name;
private String email;
private double balance;
private LocalDate date;

public MobileWallet(String mobileNo, String name, String email, double balance,
		LocalDate date) 
{
	super();
	this.mobileNo = mobileNo;
	this.name = name;
	this.email = email;
	this.balance = balance;
	this.date = date;
}
public MobileWallet() {
	super();
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
}
