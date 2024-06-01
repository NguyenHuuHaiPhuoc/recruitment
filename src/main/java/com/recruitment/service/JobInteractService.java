package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.JobInteract;

public interface JobInteractService {
	List<JobInteract> findAll();
	
	JobInteract findById(Integer id);
	
	JobInteract create(JobInteract jobInteract);
	
	JobInteract update(JobInteract jobInteract);
	
	void delete (Integer id);
}
