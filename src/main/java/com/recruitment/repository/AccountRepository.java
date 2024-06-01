package com.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitment.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	@Query(value="SELECT a.*\r\n"
			+ "FROM accounts AS a \r\n"
			+ "WHERE a.is_del = false and a.username = ?1", nativeQuery = true)
	Account findAccountByUsername(String username);
	
	boolean existsByUsername(String username);
}
