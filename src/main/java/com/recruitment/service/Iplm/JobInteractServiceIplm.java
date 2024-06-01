package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.JobInteract;
import com.recruitment.repository.JobInteractRepository;
import com.recruitment.service.JobInteractService;

@Service
public class JobInteractServiceIplm implements JobInteractService{
	@Autowired
	JobInteractRepository jobInteractRepository;
	
	@Override
	public List<JobInteract> findAll() {
		// TODO Auto-generated method stub
		return jobInteractRepository.findAll();
	}

	@Override
	public JobInteract findById(Integer id) {
		// TODO Auto-generated method stub
		return jobInteractRepository.findById(id).get();
	}

	@Override
	public JobInteract create(JobInteract jobInteract) {
		// TODO Auto-generated method stub
		return jobInteractRepository.save(jobInteract);
	}

	@Override
	public JobInteract update(JobInteract jobInteract) {
		// TODO Auto-generated method stub
		return jobInteractRepository.save(jobInteract);
	}

	@Override
	public void delete(Integer id) {
		jobInteractRepository.deleteById(id);
	}

}
