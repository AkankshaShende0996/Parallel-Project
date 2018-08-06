package com.cg.ui;

import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.exception.AccountWalletException;
import com.cg.accountwallet.service.AccountWalletService;
import com.cg.accountwallet.service.AccountWalletServiceImpl;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountWalletService service=new AccountWalletServiceImpl() ;
			Account acc=new Account();
		acc.setName("Qawdraw");
		acc.setEmail("awghsdfh@gmail.com");
		acc.setMobileNo("1234567890");
	
		acc.setBalance(1234);
		try {
			service.createAccount(acc);
		} catch (AccountWalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
