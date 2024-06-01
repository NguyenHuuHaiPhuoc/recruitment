package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.CodeOption;
import com.recruitment.exception.AppException;
import com.recruitment.exception.ErrorCode;
import com.recruitment.service.CodeOptionService;

import lombok.var;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/recruitment")
public class CodeOptionRestController {
	
	@Autowired
	CodeOptionService codeOptionService;
	
	@GetMapping("/code-option")
	public ApiResponse<CodeOption> findAllCodeOption() {
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		authentication.getAuthorities().forEach(grandAuth -> System.out.println(grandAuth.getAuthority()));
		
		ApiResponse<CodeOption> apiResp = new ApiResponse<>(0, null, null, null, null);
		List<CodeOption> listCodeoption = codeOptionService.findAllCodeOption();
		
		if (listCodeoption == null) {
			throw new AppException(ErrorCode.OPJECT_EXISTS);
		} else {
			apiResp.setStatus(200);
			apiResp.setMessage("Danh sách Code Option");
			apiResp.setListResult(listCodeoption);
		}
		return apiResp;
	}
	
	@PostMapping("/create/code-option")
	public ApiResponse<CodeOption> createCodeOption(@RequestBody CodeOption codeOption){
		System.out.println(codeOption);
		ApiResponse<CodeOption> apiResp = new ApiResponse<>(0, null, null, null, null);
		
		if (codeOptionService.existsByOptionType(codeOption.getOptionType())) {
			apiResp.setStatus(400);
			apiResp.setMessage("Loại Code Option đã tồn tại!");
		} else {
			CodeOption newCodeOption = codeOptionService.create(codeOption);
			
			apiResp.setStatus(200);
			apiResp.setMessage("Thêm thành công!");
			apiResp.setResult(newCodeOption);
		}
		
		return apiResp;
	}
	
	@PutMapping("/update/code-option")
	public ApiResponse<CodeOption> updateCodeOption(@RequestBody CodeOption codeOption){
		
		ApiResponse<CodeOption> apiResp = new ApiResponse<>(0, null, null, null, null);
		
		if (codeOptionService.existsByOptionType(codeOption.getOptionType())) {
			apiResp.setStatus(400);
			apiResp.setMessage("Loại Code Option đã tồn tại!");
		} else {
			CodeOption newCodeOption = codeOptionService.update(codeOption);
			
			apiResp.setStatus(200);
			apiResp.setMessage("Cập nhật thành công!");
			apiResp.setResult(newCodeOption);
		}
		
		return apiResp;
	}
	
	@PutMapping("/delete/code-option")
	public ApiResponse<CodeOption> deteleCodeOption(@RequestBody CodeOption codeOption){
		
		ApiResponse<CodeOption> apiResp = new ApiResponse<>(0, null, null, null, null);
		
		CodeOption newCodeOption = codeOptionService.update(codeOption);
		
		if(newCodeOption == null) {
			apiResp.setStatus(400);
			apiResp.setMessage("Xóa thất bại!");
		} else {
			apiResp.setStatus(200);
			apiResp.setMessage("Xóa thành công!");
			apiResp.setResult(newCodeOption);
		}
		
		return apiResp;
	}
}
