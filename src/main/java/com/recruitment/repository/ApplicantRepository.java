package com.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitment.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

}
