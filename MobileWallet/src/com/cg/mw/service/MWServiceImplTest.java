package com.cg.mw.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.mw.bean.MobileWallet;
import com.cg.mw.exception.MWException;
import com.cg.mw.service.IMWService;
import com.cg.mw.service.MWServiceImpl;

public class MWServiceImplTest {
	public IMWService service;

	@Before
	public void init() {
		service = new MWServiceImpl();
	}

	@Test
	public void testCreateAccountForMobile() {
		MobileWallet ac = new MobileWallet();
		ac.setMobileNo("1234");
		ac.setName("Mary");
		ac.setEmail("mary@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount("1234",ac);
		} catch (MWException e) {
			Assert.assertEquals("Mobile should contain 10 digits", e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccountForName() {
		MobileWallet ac = new MobileWallet();
		ac.setMobileNo("1234567890");
		ac.setName("mark34");
		ac.setEmail("mark@gmail.com");
		ac.setBalance(500.0);
		try {
			service.createAccount("1234567890",ac);
		} catch (MWException e) {
			Assert.assertEquals("Name should start with a capital letter and have only alphabet", e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccountForNameIsEmpty() {
		MobileWallet ac = new MobileWallet();
		ac.setMobileNo("1234567890");
		ac.setName("");
		ac.setEmail("deepu@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount("1234567890",ac);
		} catch (MWException e) {
			Assert.assertEquals("Person's name cannot be empty", e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccountForEmailId() {
		MobileWallet ac = new MobileWallet();
		ac.setMobileNo("1234567890");
		ac.setName("DeepikaS");
		ac.setEmail("deepu@@23gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount("1234567890",ac);
		} catch (MWException e) {
			Assert.assertEquals("Invalid email id", e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccountForEmail() {
		MobileWallet ac = new MobileWallet();
		ac.setMobileNo("1234567890");
		ac.setName("Deepika");
		ac.setEmail("deepu@1gmail.com");
		ac.setBalance(0);
		try {
			service.createAccount("1234567890",ac);
		} catch (MWException e) {
			Assert.assertEquals("Invalid email id", e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccount() {
		MobileWallet ac = new MobileWallet();
		ac.setMobileNo("1234567890");
		ac.setName("Deepika");
		ac.setEmail("deepu@gmail.com");
		ac.setBalance(200.0);
		
			try {
				String s=service.createAccount("1234567890",ac);
				Assert.assertNotNull(s);
			} catch (MWException e) {
				System.out.println(e.getMessage());
				
			}
		
	}
	
	@Test
	public void testShowBalanceForMobileNo() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("95059345");
		try {
			service.showBalance("95059");
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("Mobile should contain 10 digits",e.getMessage());
		}
	}
	

	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("95059");
		try {
			service.showBalance("9505928505");
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("The Account does not exist",e.getMessage());
		}
	}
	
	public void testShowBalanceForMobileNoExist() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("9505928555");
		try {
			assertSame(2000.0, service.showBalance(ac.getMobileNo()));
			
			
		} catch (MWException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testShowBalanceForName() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("9505929555");
		try {
			service.showBalance(ac.getMobileNo());
			assertEquals("Deepika", ac.getName());
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("The Account does not exist",e.getMessage());
		}
	}
	
	@Test
	public void testDepositForMobileNo() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("95059345");
		try {
			service.deposit(ac.getMobileNo(), 230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("Mobile should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testDepositForMobileNoDoesNotExist() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("9505934512");
		try {
			service.deposit(ac.getMobileNo(), 230);
		} catch (MWException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The Account does not exist",e.getMessage());
		}
	}
	@Test
	public void testDepositForDepositAmt1() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("8856234109");
		try {
			service.deposit(ac.getMobileNo(), -230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("Amount should not be negative or zero",e.getMessage());
		}
	}
	
	@Test
	public void testDeposit() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("8856234109");
		try {
			double ac1=service.deposit(ac.getMobileNo(), 230);
			assertNotEquals(0, ac1);
		} catch (MWException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testWithDrawForMobileNo() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("95059345");
		try {
			service.withdraw(ac.getMobileNo(), 230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("Mobile should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("9505934512");
		try {
			service.withdraw(ac.getMobileNo(), 230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("The Account does not exist",e.getMessage());
		}
	}
	@Test
	public void testWithdrawForAmt() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("9505928555");
		try {
			service.withdraw(ac.getMobileNo(), -230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("Amount should not be negative or zero",e.getMessage());
		}
	}
	

	@Test
	public void testFundTransferForMobileNo() {
		MobileWallet ac=new MobileWallet();
		MobileWallet ac2=new MobileWallet();
		ac.setMobileNo("95059345");
		ac2.setMobileNo("1234");
		try {
			service.fundTransactions(ac.getMobileNo(),ac2.getMobileNo(), 230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("Mobile should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferForMobileNoDoesNotExist() {
		MobileWallet ac=new MobileWallet();
		MobileWallet ac2=new MobileWallet();
		ac.setMobileNo("9505934512");
		ac2.setMobileNo("9505934782");
		try {
			service.fundTransactions(ac.getMobileNo(), ac2.getMobileNo(),  230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("The mobile number does not exist",e.getMessage());
		}
	}
	@Test
	public void testFundTransferForAmt() {
		MobileWallet ac=new MobileWallet();
		MobileWallet ac2=new MobileWallet();
		ac.setMobileNo("9505928555");
		ac2.setMobileNo("9848468242");
		try {
			service.fundTransactions(ac.getMobileNo(), ac2.getMobileNo(),  -230);
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			Assert.assertEquals("Amount should not be negative or zero",e.getMessage());
		}
	}
	

	@Test
	public void testFundTransfer() {
		MobileWallet ac=new MobileWallet();
		MobileWallet ac2=new MobileWallet();
		ac.setMobileNo("8856234109");
		ac2.setMobileNo("7804520922");
		try {
			assertEquals(230,service.fundTransactions(ac.getMobileNo(), ac2.getMobileNo(),  230));
		} catch (MWException e) {
			 //TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetails() {
		MobileWallet ac=new MobileWallet();
		ac.setMobileNo("9848468242");
		try {
			MobileWallet acc=service.printTransactionDetails(ac.getMobileNo());
			assertNotNull(acc);
		} catch (MWException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testValidateMobile() {
	try {
		boolean wallet=service.validateMobile("888abcd");		
	} catch (MWException e) {
		System.out.println(e.getMessage());
		Assert.assertEquals("Mobile should contain 10 digits",e.getMessage());
	}

	}

	@Test
	public void testValidateName() {
		try {
			boolean wallet=service.validateName("Akanksha_Shende");		
		} catch (MWException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Name should start with a capital letter and have only alphabet",e.getMessage());
		}

	}

	@Test
	public void testValidateEmail() {
		try {
			boolean wallet=service.validateEmail("%%23@gmail.com");		
		} catch (MWException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Invalid email id",e.getMessage());
		}

	}

	@Test
	public void testValidateAmount() 
	{
		try {
			boolean wallet=service.validateAmount(0);		
		} catch (MWException e) {
			System.out.println(e.getMessage());
			Assert.assertEquals("Amount should not be negative or zero",e.getMessage());
		}
	}
	
	

}