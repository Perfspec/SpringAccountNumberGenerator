package com.qa.domain;

public class Account {

	private String accountNumber;
	private String firstName;
	private String lastName;

	public Account() {

	}

	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
