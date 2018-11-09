package com.simulate.Kavanagh.bank.service;

import java.util.List;
import java.util.Scanner;

import com.simulate.Kavanagh.bank.dao.AccountDao;
import com.simulate.Kavanagh.bank.dao.AccountDaoImpl;
import com.simulate.Kavanagh.bank.model.Account;
import com.simulate.Kavanagh.bank.model.Customer;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountBank = new AccountDaoImpl();

	@Override
	public List<Account> getAllAccount() {

		return accountBank.selectAllAccount();
	}

	@Override
	public void CreateAccount(Customer newCustomer) {
		Account account = new Account(newCustomer.getClient_id(), 0.0, 0.25, "waiting for approval", null, 0, 0);

		accountBank.insertAccount(account);

	}

	public Account deposit(double amount, Account accountBank) {

		accountBank.setAccountBalance(accountBank.getAccountBalance() + amount);
		return accountBank;
	}

	@Override
	public Account update(Account updateAccount) {
		accountBank.updateAccount(updateAccount);
		return null;
	}

	public List<Account> getAccountByClientId(int client_id) {
		return accountBank.selectAccountByclient_id(client_id);

	}

	@Override
	public Account deposit(Double depositamountDouble, Account accts) {
		accts.setAccountBalance(accts.getAccountBalance() + depositamountDouble);
		return accts;
	}

	@Override
	public Account withdraw(Double withdrawamountDouble, Account accts) {
		accts.setAccountBalance(accts.getAccountBalance() - withdrawamountDouble);
		return accts;
	}

	public static void applyForanAccount(Customer newCustomer) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Now that you are  part one of our most valuable assets, "
				+ "you are able to apply for an account" + "and Make a Deposit");
		String input = sc.next();
		if (input.equals("Applyforanaccount")) {
			System.out.println("what is your credit score?");
			input = sc.next();
			List<Account> accountList = null;
			if (Integer.parseInt(input) > 600) {
				System.out.println(
						"we are happy you have decided to join us. \n Enter 'Deposit' to complete your account");

				AccountService accountService = new AccountServiceImpl();
				accountService.CreateAccount(newCustomer);

			}
			String str = sc.next();
			Account depositaccount = null;
			for (Account accts : accountList) {
				if (accts.getAccountNumber() == Integer.parseInt(str)) {
					depositaccount = accts;
					System.out.println("How much would you like to deposit?");
					String depositamount = sc.next();
					Double depositamountDouble = Double.parseDouble(depositamount);
					AccountService accountService = new AccountServiceImpl();
					accountService.CreateAccount(newCustomer);

					Account updateAccount = accountService.deposit(depositamountDouble, depositaccount);
					accountService.update(updateAccount);
				}
			}
		}

		else if (input.equals("Deposit")) {
			AccountService accountService = new AccountServiceImpl();

			System.out.println("Please select an account to deposit to");

			List<Account> accountList = accountService.getAccountByClientId(newCustomer.getClient_id());
			for (Account accountBank : accountList) {
				System.out.println(accountBank);
			}
			String str = sc.next();
			int intacct = Integer.parseInt(str);

			System.out.println("How much would you like to deposit?");
			String depAmt = sc.next();
			Double depositamountDouble = Double.parseDouble(depAmt);

			Account depAcct = null;

			for (Account accountBank : accountList) {
				if (accountBank.getAccountNumber() == intacct) {
					// ouraccount we pass into line 117
					depAcct = accountBank;

				}
			}

			Account updateAccount = accountService.deposit(depositamountDouble, depAcct);
			// str = sc.next();

			accountService.update(updateAccount);

		} else if (input.equals("Withdraw")) {
			AccountService accountService = new AccountServiceImpl();
			System.out.println("Please select an Account to withdraw from");
			List<Account> accountList = accountService.getAccountByClientId(newCustomer.getClient_id());
			for (Account accountBank : accountList) {
				System.out.println(accountBank);
			}
			System.out.println("which account would you like to withdraw?");
			String str = sc.next();
			Account withdrawaccount = null;
			for (Account accts : accountList) {
				if (accts.getAccountNumber() == Integer.parseInt(str)) {
					withdrawaccount = accts;
					// System.out.println("How much would you like to withdraw?");
					String withdrawamount = sc.next();
					Double withdrawamountDouble = Double.parseDouble(withdrawamount);
					if (withdrawamountDouble > accts.getAccountBalance()) {
						System.out.println("insuffienct funds!!");
					} else {
						Account updateAccount = accountService.deposit(withdrawamountDouble, withdrawaccount);
						accountService.update(updateAccount);
					}

				}

			}
		} else if (input.equals("Transfer")) {
			AccountService accountService = new AccountServiceImpl();
			System.out.println("Please select an Account to transfer from?");
			List<Account> accountList = accountService.getAccountByClientId(newCustomer.getClient_id());
			for (Account accountBank : accountList) {
				System.out.println(accountBank);
			}
			System.out.println("How much would you like to withdraw?");
			String str = sc.next();
			Account transferfromaccount = null;
			for (Account accts : accountList) {
				if (accts.getAccountNumber() == Integer.parseInt(str)) {
					transferfromaccount = accts;
					System.out.println("Please select the account you would like to transfer to?");
					for (Account accountBank : accountList) {
						System.out.println(accountBank);
					}
					String trans = sc.next();
					Account transfertoaccount = null;
					for (Account acctss : accountList) {
						if (acctss.getAccountNumber() == Integer.parseInt(trans)) {
							transfertoaccount = acctss;

							System.out.println("How much would you like transfer?");
							String transferamount = sc.next();

							Double transferamountDouble = Double.parseDouble(transferamount);
							if (transferamountDouble > accts.getAccountBalance()) {
								System.out.println("insuffienct funds!!");
							} else {
								Account updateAccount = accountService.withdraw(transferamountDouble,
										transferfromaccount);
								accountService.update(updateAccount);
								updateAccount = accountService.deposit(transferamountDouble, transfertoaccount);
								accountService.update(updateAccount);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public List<Account> getAccountByAccountNumber(double accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
