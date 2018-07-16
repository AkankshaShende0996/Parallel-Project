package com.cg.mw.db;

import java.time.LocalDate;
import java.util.HashMap;

import com.cg.mw.bean.MobileWallet;

public class MWDb 
{
	private static HashMap< String, MobileWallet> walletDb=new HashMap<String, MobileWallet>();

	public static HashMap<String, MobileWallet> getWalletDb() {
		return walletDb;
	}
	public static void setWalletDb(HashMap<String, MobileWallet> walletDb) {
		MWDb.walletDb = walletDb;
	}
	static	
	{
	walletDb.put("8856234109",new MobileWallet("8856234109","Akanksha","akanksha@gmail.com",1000,LocalDate.of(2016,9,28) ) )	;
	walletDb.put("8856234109",new MobileWallet("7804520922","Narmatha","narmatha@gmail.com",500,LocalDate.of(2017,6,18)) )	;
	walletDb.put("9785620194",new MobileWallet("9785620194","Sruthi","sruthi@gmail.com",500,LocalDate.of(2018,3,10)) )	;
	}
}
