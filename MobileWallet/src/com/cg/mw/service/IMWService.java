package com.cg.mw.service;

import com.cg.mw.bean.MobileWallet;
import com.cg.mw.exception.MWException;

public interface IMWService 
{
	public String createAccount(String mobileNo,MobileWallet wallet) throws MWException;
	public double showBalance(String mobileNo) throws MWException;
	public double deposit(String mobileNo,double recharge) throws MWException;
	public double withdraw(String mobileNo,double amount) throws MWException;
	 public double fundTransactions(String sender,String receiver,double amount) throws MWException;
	 public boolean validateAmount(double amount) throws MWException;
	 public boolean validateEmail(String email) throws MWException;
	 public boolean validateName(String name) throws MWException;
	 public boolean validateMobile(String mobile) throws MWException;
	public MobileWallet printTransactionDetails(String mobileNo) throws MWException;
}
