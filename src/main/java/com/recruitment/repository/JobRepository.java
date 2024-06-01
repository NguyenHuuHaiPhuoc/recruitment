package com.recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitment.entity.Jobs;

public interface JobRepository extends JpaRepository<Jobs, Integer>{
	
	@Query(value="SELECT \r\n"
			+ "	id\r\n"
			+ "	,position\r\n"
			+ "	,level\r\n"
			+ "	,tech_use\r\n"
			+ "	,salary\r\n"
			+ "	,member\r\n"
			+ "	,expiration_date\r\n"
			+ "	,year_exp\r\n"
			+ "	,contract_type\r\n"
			+ "	,working_form\r\n"
			+ "	,job_desc\r\n"
			+ "	,require\r\n"
			+ "	,welfare\r\n"
			+ "	,time_work\r\n"
			+ "	,address_work\r\n"
			+ "	,create_date\r\n"
			+ "	,(SELECT a.full_name FROM accounts AS a WHERE a.is_del = 'false' AND a.id = CAST(create_by AS INTEGER)) as create_by\r\n"
			+ "	,status\r\n"
			+ "	,is_confirmed\r\n"
			+ "	,confirm_by\r\n"
			+ "FROM jobs\r\n"
			+ "WHERE jobs.status = 'false'\r\n"
			+ "AND jobs.create_by = ?1", nativeQuery = true)
	List<Jobs> getJob(String id);
}
