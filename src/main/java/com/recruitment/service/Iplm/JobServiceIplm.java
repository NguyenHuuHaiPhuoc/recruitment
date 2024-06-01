package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Jobs;
import com.recruitment.exception.AppException;
import com.recruitment.exception.ErrorCode;
import com.recruitment.repository.JobRepository;
import com.recruitment.service.JobService;

@Service
public class JobServiceIplm implements JobService{
	@Autowired
	JobRepository jobRepository;
	
	@Override
	public List<Jobs> findAll() {
		List<Jobs> listJobs = jobRepository.findAll();
		if (listJobs == null) 
			throw new AppException(ErrorCode.OPJECT_NOT_FOUND);
		return listJobs;
	}

	@Override
	public Jobs findById(Integer id) {
		return jobRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Job not found"));
	}

	@Override
	public Jobs create(Jobs job) {
		Jobs newJob = jobRepository.save(job);
		if (newJob == null)
			throw new AppException(ErrorCode.CREATE_FAIL);
		return newJob;
	}

	@Override
	public Jobs update(Jobs job) {
		// TODO Auto-generated method stub
		return jobRepository.save(job);
	}

	@Override
	public void delete(Integer id) {
		jobRepository.deleteById(id);
	}

	@Override
	public List<Jobs> getJob(String id) {
		// TODO Auto-generated method stub
		return jobRepository.getJob(id);
	}

}
