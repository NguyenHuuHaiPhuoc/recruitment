package com.recruitment.service;

import java.util.List;

import com.recruitment.entity.Process;

public interface ProcessService {
	List<Process> findAll();
	
	Process findById(Integer id);
	
	Process create(Process process);
	
	Process update(Process process);
	
	void delete(Integer id);
	
	List<Process> processByJobId(Integer id);
}
