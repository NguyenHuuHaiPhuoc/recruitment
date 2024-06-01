package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Applicant;
import com.recruitment.repository.ApplicantRepository;
import com.recruitment.service.ApplicantService;

@Service
public class ApplicantServiceIplm implements ApplicantService{

	@Autowired
	ApplicantRepository applicantRepository;
	
	@Override
	public List<Applicant> findAll() {
		// TODO Auto-generated method stub
		return applicantRepository.findAll();
	}

	@Override
	public Applicant create(Applicant applicant) {
		// TODO Auto-generated method stub
		return applicantRepository.save(applicant);
	}

	@Override
	public Applicant update(Applicant applicant) {
		// TODO Auto-generated method stub
		return applicantRepository.save(applicant);
	}

	@Override
	public void delete(Integer id) {
		applicantRepository.deleteById(id);
	}

}
