package com.recruitment.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Account;
import com.recruitment.repository.AccountRepository;
import com.recruitment.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> findAll() {
		
		return accountRepository.findAll();
	}

}
