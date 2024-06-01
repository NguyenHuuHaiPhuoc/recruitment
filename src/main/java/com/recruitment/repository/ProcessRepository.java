package com.recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitment.entity.Process;

public interface ProcessRepository extends JpaRepository<Process, Integer>{
	@Query(value="SELECT * FROM process WHERE job_id = ?1", nativeQuery = true)
	List<Process> processByJobId(Integer id);
	
	
}
