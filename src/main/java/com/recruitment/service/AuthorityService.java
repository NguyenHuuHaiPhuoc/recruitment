package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Authority;

public interface AuthorityService {
	List<Authority> findAll();
	
	Authority create(Authority authority);
	
	Authority update(Authority authority);
	
	void delete(Integer id);
}
