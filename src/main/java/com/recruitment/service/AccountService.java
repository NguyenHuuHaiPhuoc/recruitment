package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Account;

public interface AccountService {
	List<Account> findAll();
	
	Account findByAccount(String username);
	
	boolean existsByUsername(String username);
	
	Account create(Account account);
	
	Account update(Account account);
	
	void delete(Integer id);
}
