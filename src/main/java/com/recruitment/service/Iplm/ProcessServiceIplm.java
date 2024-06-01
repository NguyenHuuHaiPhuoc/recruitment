package com.recruitment.service.Iplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Process;
import com.recruitment.repository.ProcessRepository;
import com.recruitment.service.ProcessService;

@Service
public class ProcessServiceIplm implements ProcessService{
	@Autowired
	ProcessRepository processRepository;
	
	@Override
	public List<Process> findAll() {
		// TODO Auto-generated method stub
		return processRepository.findAll();
	}

	@Override
	public Process findById(Integer id) {
		// TODO Auto-generated method stub
		return processRepository.findById(id).get();
	}

	@Override
	public Process create(Process process) {
		// TODO Auto-generated method stub
		return processRepository.save(process);
	}

	@Override
	public Process update(Process process) {
		// TODO Auto-generated method stub
		return processRepository.save(process);
	}

	@Override
	public void delete(Integer id) {
		processRepository.deleteById(id);
	}

	@Override
	public List<Process> processByJobId(Integer id) {
		return processRepository.processByJobId(id);
	}

}
