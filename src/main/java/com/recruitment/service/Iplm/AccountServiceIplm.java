package com.recruitment.service.Iplm;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Account;
import com.recruitment.exception.AppException;
import com.recruitment.exception.ErrorCode;
import com.recruitment.repository.AccountRepository;
import com.recruitment.service.AccountService;

@Service
public class AccountServiceIplm implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account create(Account account) {
		if(accountRepository.existsByUsername(account.getUsername()))
			throw new AppException(ErrorCode.OPJECT_EXISTS);
		
		return accountRepository.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
	}

	@Override
	public Account findByAccount(String username) {
		return accountRepository.findAccountByUsername(username);
	}

	@Override
	public boolean existsByUsername(String username) {
		return accountRepository.existsByUsername(username);
	}

}
