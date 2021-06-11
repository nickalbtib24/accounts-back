package com.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Optional<Account> findAccountByDocumentNumber(String documentNumber);
	
}
