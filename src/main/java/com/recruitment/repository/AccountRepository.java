package com.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitment.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
}
