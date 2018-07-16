package com.cg.mw.dao;

import java.util.HashMap;

import com.cg.mw.bean.MobileWallet;
import com.cg.mw.db.MWDb;
import com.cg.mw.exception.MWException;

public class MWDaoImpl implements IMWDao
{
	 static HashMap<String, MobileWallet> walletMap=MWDb.getWalletDb();
	 MobileWallet mobwall =new MobileWallet();
	 @Override
	public String createAccount(String mobileNo,MobileWallet wallet) throws MWException
	{
		if(walletMap.containsKey(mobileNo))
		{
			throw new MWException("The Account already exists");
		}
		if(wallet.getBalance()<0)
		{
			throw new MWException("Amount should be more than zero");
		}
			walletMap.put(mobileNo, wallet);
			return wallet.getMobileNo();
		
	}
	 
	 @Override
	public double showBalance(String mobileNo) throws MWException
	{
		
		if(!walletMap.containsKey(mobileNo))
		{
			throw new MWException("The Account does not exist");
		}
		mobwall =walletMap.get(mobileNo);
		return mobwall.getBalance();
		
	}
	 
	 @Override
	public double deposit(String mobileNo,double recharge) throws MWException
	{
		if(!walletMap.containsKey(mobileNo))
		{
			throw new MWException("The Account does not exist");
		}
		mobwall =walletMap.get(mobileNo);
		mobwall.setBalance(recharge+mobwall.getBalance());
		walletMap.replace(mobileNo, mobwall);
		return mobwall.getBalance();
		

	}
	 
	 @Override
	public double withdraw(String mobileNo,double amount) throws MWException
	{
		if(!walletMap.containsKey(mobileNo))
		{
			throw new MWException("The Account does not exist");
		}
		mobwall =walletMap.get(mobileNo);
		if(mobwall.getBalance()<amount)
		{
			throw new MWException("Your Account Balance is less than the amount to be withdrawn");
		}
		mobwall.setBalance(mobwall.getBalance()-amount);
		walletMap.replace(mobileNo, mobwall);
		
		return mobwall.getBalance();
		
	}
	 
	 @Override
	 public double fundTransactions(String sender,String receiver,double amount) throws MWException
	 {
		 if(walletMap.containsKey(sender))
		 {
			 if(!walletMap.containsKey(receiver))
			 {
				 throw new MWException("The sender does not exist");
			 }
			
			 mobwall=walletMap.get(sender);
			if(mobwall.getBalance()!=0)
			{
				withdraw(sender,amount);
				MobileWallet rec=new MobileWallet();
				rec=walletMap.get(receiver);
				rec.setBalance(amount+rec.getBalance());
				walletMap.replace(receiver, rec);
			}
		 }
		return amount;
		 
	 }

	@Override
	public MobileWallet printTransactionDetails(String mobileNo)
			throws MWException {
		MobileWallet wallet=walletMap.get(mobileNo);
		if(wallet==null)
		{
			throw new MWException("Mobile Number does not exist");
		}
		return wallet;
	}
	
}
