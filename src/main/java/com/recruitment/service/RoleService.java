package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Role;

public interface RoleService {
	List<Role> findAll();
	
	Role create(Role role);
	
	Role update(Role role);
	
	void delete(Integer id);
}
