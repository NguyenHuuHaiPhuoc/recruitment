package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.Applicant;
import com.recruitment.service.ApplicantService;

@CrossOrigin("*")
@RestController
public class ApplicantRestController {
	
	@Autowired
	ApplicantService applicantService;
	
	@GetMapping("/api/recruitment/applicant")
	public List<Applicant> getAllApplicant(){
		return applicantService.findAll();
	}
	
	@PostMapping("/recruitment/create/applicant")
	public ApiResponse<Applicant> createApplicant(@RequestBody Applicant applicant){
		ApiResponse<Applicant> apiResponse =  new ApiResponse<Applicant>(0, null, null, null, null);
		Applicant newApplicant = applicantService.create(applicant);
		
		if(newApplicant != null) {
			apiResponse.setStatus(200);
			apiResponse.setMessage("Tạo mới công ty thành công!");
			apiResponse.setResult(newApplicant);
		}
		return apiResponse;
	}
}
