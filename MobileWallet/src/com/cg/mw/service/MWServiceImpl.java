package com.cg.mw.service;

import com.cg.mw.bean.MobileWallet;
import com.cg.mw.dao.IMWDao;
import com.cg.mw.dao.MWDaoImpl;
import com.cg.mw.exception.MWException;

public class MWServiceImpl implements IMWService
{
	IMWDao walletDao=new MWDaoImpl();
	
	@Override
	public String createAccount(String mobileNo, MobileWallet wallet) throws MWException
	{
		validateMobile(mobileNo);
		validateName(wallet.getName());
		validateEmail(wallet.getEmail());
		if(wallet.getBalance()<0)
		{
			throw new MWException("Amount should be more than zero");
		}
		return walletDao.createAccount(mobileNo, wallet);
	}
	@Override
	public double deposit(String mobileNo,double recharge) throws MWException
	{
		validateAmount(recharge);
		validateMobile(mobileNo);
		if(recharge<0)
		{
			throw new MWException("Amount should be more than zero");			
		}
		return walletDao.deposit(mobileNo, recharge);
	}
	@Override
	public double withdraw(String mobileNo, double amount) throws MWException 
	{
		validateAmount(amount);
		validateMobile(mobileNo);
		if(amount<0)
		{
			throw new MWException("Amount should be more than zero");			
		}
		return walletDao.withdraw(mobileNo, amount);
		
	}
	
	@Override
	public double showBalance(String mobileNo) throws MWException 
	{
		validateMobile(mobileNo);
		return walletDao.showBalance(mobileNo);
	
	}
	
	@Override
	public double fundTransactions(String sender, String receiver, double amount)
			throws MWException {
		validateAmount(amount);
		validateMobile(sender);
		validateMobile(receiver);
		return walletDao.fundTransactions(sender, receiver, amount);
	}
	
	public boolean validateMobile(String mobile) throws MWException
	{
		if(!mobile.matches("\\d{10}"))
		{
			throw new MWException("Mobile should contain 10 digits");
		}
		return true;
		
	}
	public boolean validateName(String name) throws MWException
	{
		if(name.isEmpty() || name==null)
		{
			throw new MWException("Person's name cannot be empty");
		}
		else
		{
			if(!name.matches("[A-Z][A-Za-z]{3,}"))
			{
				throw new MWException("Name should start with a capital letter and have only alphabet");
			}
		}
		return true;
		
	}
	public boolean validateEmail(String email) throws MWException
	{
		if(email.isEmpty() || email==null)
		{
			throw new MWException("Email cannot be empty");
		}
		
			if(!email.matches("[a-z0-9]{3,}[@][a-z]{2,8}[.com]"))
			{
				throw new MWException("Invalid email id");
			}
		
		return true;
		
	}
	public boolean validateAmount(double amount) throws MWException
	{
		if(amount<=0)
		{
			throw new MWException("Amount should not be negative or zero");
		}
		return true;
		
	}
	@Override
	public MobileWallet printTransactionDetails(String mobileNo) throws MWException
	{		
		return walletDao.printTransactionDetails(mobileNo);
	}
	
}
