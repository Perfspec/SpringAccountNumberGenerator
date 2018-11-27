package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import com.qa.business.service.AccountService;
import com.qa.business.service.IAccountService;
import com.qa.domain.Account;

public class HibernateAccountRepositoryImpl implements AccountRepository {

	private IAccountService acc = new AccountService();
	private List<Account> customers = new ArrayList<>();
	
	public List<Account> findAll() {
	
		return customers;
	}

	
	public String createAccount(String firstName, String lastName, int accountType) {
		Account account = new Account();
		account.setAccountNumber(acc.generateAccountNum(accountType));
		account.setFirstName(firstName);
		account.setLastName(lastName);
		
		customers.add(account);
		
		return "Account successfully created";
	}
	
	public void setService(IAccountService account) {
		this.acc = account;
	}

}
