package com.cg.accountwallet;


import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.accountwallet.bean.Account;
import com.cg.accountwallet.exception.AccountWalletException;
import com.cg.accountwallet.service.AccountWalletService;
import com.cg.accountwallet.service.AccountWalletServiceImpl;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static AccountWalletService service = null;

	@BeforeClass
	public void setUp() {
		service=new AccountWalletServiceImpl();
	}
	@Test
	public void testCreate() {
		Account account = new Account();
		account.setMobileNo("1234567890");
		account.setName("Simeon");
		account.setEmail("simeon777@gmail.com");
		account.setBalance(500.0);
		
		try {
			assertNotNull(service.createAccount(account));
		} catch (AccountWalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(expected=AccountWalletException.class)
	public void testCreateAccountForName() throws AccountWalletException {
		Account ac = new Account();
		ac.setMobileNo("1234567890");
		ac.setName("simeon777");
		ac.setEmail("simeon777@gmail.com");
		ac.setBalance(500.0);
		try {
			service.createAccount(ac);
		} catch (AccountWalletException e) {
			// TODO Auto-generated catch block
			assertEquals("Name should start with capital letter and should contain only alphabets",e.getMessage());
		}
	}
		@Test(expected=AccountWalletException.class)
		public void testCreateAccountForEmailId() throws AccountWalletException{
			Account account = new Account();
			account.setMobileNo("1234567890");
			account.setName("Simeon");
			account.setEmail("simeon777@@gmail.com");
			account.setBalance(500.0);
			try {
				service.createAccount(account);
			} catch (AccountWalletException e) {
				// TODO Auto-generated catch block
				assertEquals("Enter valid emailid",e.getMessage());
			}
			
		}
		@Test
		public void testCreateAccountForNameIsEmpty() {
			Account ac = new Account();
			ac.setMobileNo("7981123927");
			ac.setName("");
			ac.setEmail("simeon777@gmail.com");
			ac.setBalance(500.0);
			try {
				service.createAccount(ac);
			} catch (AccountWalletException e) {
				assertEquals("Name cannot be empty", e.getMessage());
			}
		}
		@Test
		public void testShowBalanceForMobileNo() {
			try {
				service.showBalance("95059");
			} catch (AccountWalletException e) {
				assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}

		@Test
		public void testCreateAccount() {
			Account account = new Account();
			account.setMobileNo("7981123927");
			account.setName("Simeon");
			account.setEmail("simeon777@gmail.com");
			account.setBalance(500.0);
		}



		@Test
		public void testDepositForMobileNo() {
			Account account = new Account();
			account.setMobileNo("79811239");
			try {
				service.deposit(account.getMobileNo(), 230);
			} catch (AccountWalletException e) {
				assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}



		@Test
		public void testWithDrawForMobileNo() {
			Account ac = new Account();
			ac.setMobileNo("79811239");
			try {
				service.withdraw(ac.getMobileNo(), 230);
			} catch (AccountWalletException e) {
				assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}

		@Test
		public void testDepositForDepositAmt1() {
			Account ac = new Account();
			ac.setMobileNo("9949565567");
			try {
				service.deposit(ac.getMobileNo(), -500);
			} catch (AccountWalletException e) {
				assertEquals("Deposit amount must be greater than zero", e.getMessage());
			}
		}

		@Test
		public void testWithdrawForAmt() {
			Account acc = new Account();
			acc.setMobileNo("9949565567");
			try {
				service.withdraw(acc.getMobileNo(), -530);
			} catch (AccountWalletException e) {
				assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",
						e.getMessage());
			}
		}

		@Test
		public void testFundTransferForMobileNo() {
			Account account = new Account();
			Account account1 = new Account();
			account.setMobileNo("7981123");
			account1.setMobileNo("1234");
			try {
				service.fundTransfer(account.getMobileNo(), account1.getMobileNo(), 230);
			} catch (AccountWalletException e) {
				assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}

		@Test
		public void testFundTransferForMobileNoDoesNotExist() {
			Account acc = new Account();
			Account acc1 = new Account();
			acc.setMobileNo("7981123927");
			acc1.setMobileNo("9949565567");
			/*
			 * try { service.fundTransfer(acc.getMobileNo(), acc1.getMobileNo(), 230); }
			 * catch (AccountWalletException e) {
			 * assertEquals("The mobile number does not exist",e.getMessage()); }
			 */
		}

		// existing number should only given
		@Test
		public void testFundTransferForAmt() {
			Account account = new Account();
			Account account1 = new Account();
			account.setMobileNo("9949565567");
			account1.setMobileNo("8309963649");
			try {
				service.fundTransfer(account.getMobileNo(), account1.getMobileNo(), -500);
			} catch (AccountWalletException e) {
				assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",
						e.getMessage());
			}
		}


		@Test
		public void testCreateAccountForMobile() {
			Account ac = new Account();
			ac.setMobileNo("9573");
			ac.setName("Simeon");
			ac.setEmail("simeon@gmail.com");
			ac.setBalance(200.0);
			try {
				service.createAccount(ac);
			} catch (AccountWalletException e) {
				assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
		}


		
	}

