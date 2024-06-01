package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Applicant;

public interface ApplicantService {
	
	List<Applicant> findAll();
		
	Applicant create(Applicant applicant);
		
	Applicant update(Applicant applicant);
		
	void delete(Integer id);
}
