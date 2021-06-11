package com.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Account")
public class Account {

	@Id
	@SequenceGenerator(
			name = "account_sequence",
			sequenceName = "account_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "account_sequence"
	)
	
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="document_number")
	private String documentNumber;
	
	@Column(name="balance")
	private int balance;

	public Account() {
		super();
	}
	
	public Account(String name, String documentNumber, int balance) {
		this.name = name;
		this.documentNumber = documentNumber;
		this.balance = balance;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
