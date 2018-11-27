package com.qa.business.service;

import com.qa.domain.Account;

public class PrizeGenerator implements IPrizeGenerator {

	@Override
	public String generatePrize(Account account) {
		if (checkLetter(account.getAccountNumber()) != 0) {
			return "You have won " + checkLetter(account.getAccountNumber());
		}
		return null;

	}

	public int checkLetter(String accountNumber) {
		switch (accountNumber.charAt(0)) {
		case 'A':
			return (int) (Math.pow(4, checkLength(accountNumber)) * 25);
		case 'B':
			return (int) (Math.pow(4, checkLength(accountNumber)) * 50);
			}
		return 0;
		
	}

	public int checkLength(String accountNumber) {
		switch (accountNumber.length()) {
		case 7:
			return 0;
		case 9:
			return 1;
		case 11:
			return 2;
		}
		return 0;
	}

}
