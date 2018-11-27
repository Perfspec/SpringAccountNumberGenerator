package com.qa.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.qa.domain.Account;
import com.qa.persistence.repository.AccountRepository;

public class AccountService implements IAccountService{
	private List<Account> accountList = new ArrayList<Account>();
	private String accountNumber = " ";
	private int givenNumber = 100000;
	private AccountRepository repo;
	private IPrizeGenerator prize;
	private Account account;

	public String CreateAccount(String firstName, String lastName, int accountType) {

		account = new Account();
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setAccountNumber(generateAccountNum(accountType));

		return "Account successfully created";
	}

	public String generateAccountNum(int givenNumber) {
		Random rand = new Random();
		int num = rand.nextInt(givenNumber * 9) + givenNumber;

		int letterNum = rand.nextInt(3);
		String letter;
		switch (letterNum) {
		case 0:
			letter = "A";
			break;
		case 1:
			letter = "B";
			break;
		case 2:
			letter = "C";
			break;
		default:
			letter = "Invalid number";
			break;
		}

		if (givenNumber > 10000000) {
			int num2 = rand.nextInt(3);
			accountNumber = letter + num + num2;
		} else {

			accountNumber = letter + num;
		}

		for (Account str : accountList) {
			if (str.getAccountNumber().contains(accountNumber))
				System.out.println("Account Exists");
		}
		
		return accountNumber;
	}

	public void setAccountRepo(AccountRepository repo) {
		this.repo = repo;
	}

	public void setPrizeGenerator(IPrizeGenerator gen) {
		this.prize = gen;
	}

}
