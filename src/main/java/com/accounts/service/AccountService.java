package com.accounts.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.exception.AccountAlreadyExistsException;
import com.accounts.exception.AccountNotFoundException;
import com.accounts.exception.InsufficientFundsException;
import com.accounts.model.Account;
import com.accounts.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;
	
	public Account createAccount(Account account) throws Exception {
		Optional<Account> accountAux = repository.findAccountByDocumentNumber(account.getDocumentNumber());
		if (account.getBalance() >= 50000) {
			if (accountAux.isPresent()) {
				throw new AccountAlreadyExistsException("El número de documento ingresado ya tiene una cuenta asignada.");
			} else {
				account = repository.save(account);
				return account;
			}
		} else {
			throw new InsufficientFundsException("El monto mínimo para crear una cuenta es de $50.000.");
		}
	}
	
	public Account getAccountByDocumentNumber(String documentNumber) throws AccountNotFoundException {
		Optional<Account> account = repository.findAccountByDocumentNumber(documentNumber);
		if (account.isPresent()) {
			return account.get();
		} else {
			throw new AccountNotFoundException("No se encontró una cuenta con el número de documento especificado.");
		}
	}
}
