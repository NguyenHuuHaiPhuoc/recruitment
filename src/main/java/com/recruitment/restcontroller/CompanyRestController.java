package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.Company;
import com.recruitment.service.CompanyService;

@CrossOrigin("*")
@RestController
//@RequestMapping("/api/recruitment")
public class CompanyRestController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/api/recruitment/company")
	public ApiResponse<Company> findAllCompany(){
		ApiResponse<Company> apiResp = new ApiResponse<Company>(0, null, null, null, null);
		List<Company> company = companyService.findAll();
		
		if (company == null) {
			apiResp.setStatus(100);
			apiResp.setMessage("Không thấy dữ liệu!");
			apiResp.setListResult(null);
		} else {
			apiResp.setStatus(200);
			apiResp.setMessage("Tìm thấy dữ liệu!");
			apiResp.setListResult(company);
		}
		return apiResp;
	}
	
	@PostMapping("/recruitment/create/company")
	public ApiResponse<Company> createCompany(@RequestBody Company company) {
		ApiResponse<Company> apiResp = new ApiResponse<Company>(0, null, null, null, null);
		Company newCompany = companyService.create(company);
		
		if ( newCompany != null) {
			apiResp.setStatus(200);
			apiResp.setMessage("Tạo mới công ty thành công!");
			apiResp.setResult(company);
		}
		return apiResp;
	}
}
