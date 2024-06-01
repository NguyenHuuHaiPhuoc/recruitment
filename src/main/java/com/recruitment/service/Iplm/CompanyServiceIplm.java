package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Company;
import com.recruitment.repository.CompanyRepository;
import com.recruitment.service.CompanyService;

@Service
public class CompanyServiceIplm implements CompanyService{

	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public Company create(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	@Override
	public Company update(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	@Override
	public void delete(Integer id) {
		companyRepository.deleteById(id);
	}

}
