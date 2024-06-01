package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Authority;
import com.recruitment.repository.AuthorityRepository;
import com.recruitment.service.AuthorityService;

@Service
public class AuthorityServiceIplm implements AuthorityService{

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityRepository.findAll();
	}

	@Override
	public Authority create(Authority authority) {
		// TODO Auto-generated method stub
		return authorityRepository.save(authority);
	}

	@Override
	public Authority update(Authority authority) {
		// TODO Auto-generated method stub
		return authorityRepository.save(authority);
	}

	@Override
	public void delete(Integer id) {
		authorityRepository.deleteById(id);
	}

}
