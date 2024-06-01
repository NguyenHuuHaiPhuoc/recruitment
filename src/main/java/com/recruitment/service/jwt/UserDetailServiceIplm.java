package com.recruitment.service.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Account;
import com.recruitment.repository.AccountRepository;

@Service
public class UserDetailServiceIplm implements UserDetailsService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findAccountByUsername(username);
//		System.out.println(account.getUsername());
		if (account.getUsername() == null) {
			throw new UsernameNotFoundException("User not found",null);
		}
		return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), new ArrayList<>());
	}

}
