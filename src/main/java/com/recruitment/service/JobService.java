package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Jobs;

public interface JobService {
	List<Jobs> findAll();
	
	Jobs findById(Integer id);
	
	Jobs create(Jobs job);
	
	Jobs update(Jobs job);
	
	void delete(Integer id);
	
	List<Jobs> getJob(String id);
}
