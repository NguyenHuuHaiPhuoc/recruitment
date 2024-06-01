package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Admin;

public interface AdminService {
	
	List<Admin> findAll();
		
//	Admin findByAccount(String admin);
		
//	boolean existsByUsername(String admin);
	
	Admin create(Admin admin);
	
	Admin update(Admin admin);
	
	void delete(Integer id);
}
