package com.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitment.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
