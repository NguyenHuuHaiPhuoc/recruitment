package com.recruitment.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.Admin;
import com.recruitment.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/recruitment")
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin")
	public ApiResponse<Admin> createAdmin (@RequestBody Admin admin) {
		
		ApiResponse<Admin> apiResp = new ApiResponse<Admin>(0, null, null, null, null);
		Admin newAdmin = adminService.create(admin);
		
		if (newAdmin != null) {
			apiResp.setStatus(200);
			apiResp.setMessage("Tạo mới thành công!");
			apiResp.setResult(newAdmin);
		}
		
		return apiResp;
	}
}
