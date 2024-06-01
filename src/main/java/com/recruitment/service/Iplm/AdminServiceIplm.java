package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Admin;
import com.recruitment.exception.AppException;
import com.recruitment.exception.ErrorCode;
import com.recruitment.repository.AdminRepository;
import com.recruitment.service.AdminService;

@Service
public class AdminServiceIplm implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin create(Admin admin) {
		Admin newAdmin = adminRepository.save(admin);
		
		if(newAdmin == null)
			throw new AppException(ErrorCode.CREATE_FAIL);
		
		return newAdmin;
	}

	@Override
	public Admin update(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public void delete(Integer id) {
		adminRepository.deleteById(id);
	}

}
