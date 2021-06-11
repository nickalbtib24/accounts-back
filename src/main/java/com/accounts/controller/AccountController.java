package com.accounts.controller;

import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.exception.AccountAlreadyExistsException;
import com.accounts.exception.AccountNotFoundException;
import com.accounts.model.Account;
import com.accounts.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@GetMapping("/get-account/{documentNumber}")
	public ResponseEntity<Object> getAccountByDocumentNumber(@PathVariable("documentNumber") String documentNumber) throws AccountNotFoundException {
		Account fetchAccount = service.getAccountByDocumentNumber(documentNumber);
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("account", fetchAccount);
	    body.put("code", 0);
		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/create-account")
	public ResponseEntity<Object> createAccount(@RequestBody Account account) throws Exception {
		Account createdAccount = service.createAccount(account);
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("account", createdAccount);
	    body.put("code", 0);
		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.OK);
		
	}
}
