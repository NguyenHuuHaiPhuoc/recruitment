package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Company;

public interface CompanyService {
	List<Company> findAll();
	
	Company create(Company company);
	
	Company update(Company company);
	
	void delete(Integer id);
}
