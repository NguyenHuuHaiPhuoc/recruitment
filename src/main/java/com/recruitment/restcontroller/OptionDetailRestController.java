package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.OptionDetail;
import com.recruitment.exception.AppException;
import com.recruitment.exception.ErrorCode;
import com.recruitment.service.OptionDetailService;

@CrossOrigin("*")
@RestController
//@RequestMapping("/recruitment/")
public class OptionDetailRestController {
	@Autowired
	OptionDetailService detailService;
	
	@GetMapping("/recruitment/option_detail")
	public List<OptionDetail> findAll(){
		return detailService.findAll();
	}
	
	@GetMapping("/recruitment/option_detail/tecnologies")
	public List<OptionDetail> findAllTechnology(){
		return detailService.technologiesUsing();
	}
	
	@GetMapping("/recruitment/option_detail/contract_types")
	public List<OptionDetail> findAllContractType(){
		return detailService.contract_types();
	}
	
	@GetMapping("/recruitment/option_detail/working_forms")
	public List<OptionDetail> findAllWorkingForm(){
		return detailService.working_forms();
	}
	
	@GetMapping("/recruitment/option_detail/levels")
	public List<OptionDetail> findAllLevel(){
		return detailService.levels();
	}
	
	@GetMapping("/recruitment/option_detail/{id}")
	public OptionDetail findById(@PathVariable("id") Integer id){
		return detailService.findById(id);
	}
	
	@GetMapping("/api/recruitment/option_detail_by_code_option/id={id}")
	public ApiResponse<OptionDetail> optionDetailByCodeOptionID(@PathVariable("id") Integer id){
		ApiResponse<OptionDetail> apiResp = new ApiResponse<OptionDetail>(0, null, null, null, null);
		List<OptionDetail> listOptionDetail = detailService.optionDetailByCodeOptionId(id);
		
		if (listOptionDetail == null) {
			throw new AppException(ErrorCode.OPJECT_NOT_FOUND);
		} else {
			apiResp.setStatus(200);
			apiResp.setMessage("Danh sách Option Detail.");
			apiResp.setListResult(listOptionDetail);
		}
		return apiResp;
	}
	
	@PostMapping("/api/recruitment/option_detail")
	public ApiResponse<OptionDetail> createOPDetail (@RequestBody OptionDetail opDetail) {
		ApiResponse<OptionDetail> apiResp = new ApiResponse<>(0, null, null, null, null);
		
		if (detailService.existsByOptionName
				(opDetail.getCodeOption().getId(), opDetail.getOption_name())
			)
		{
			apiResp.setStatus(400);
			apiResp.setMessage("Đã tồn tại!");
		} else {
			OptionDetail newOpDetail = detailService.create(opDetail);
			
			apiResp.setStatus(200);
			apiResp.setMessage("Thêm mới thành công!");
			apiResp.setResult(newOpDetail);
		}
		
		return apiResp;
	}
	
	@PutMapping("/api/recruitment/update/option_detail")
	public ApiResponse<OptionDetail> updateOPDetail(@RequestBody OptionDetail opDetail){
		
		ApiResponse<OptionDetail> apiResp = new ApiResponse<>(0, null, null, null, null);
		
		if (detailService.existsByOptionName
				(opDetail.getCodeOption().getId(), opDetail.getOption_name())
				)
		{
			apiResp.setStatus(400);
			apiResp.setMessage("Đã tồn tại!");
		} else {
			OptionDetail newOPDetail = detailService.update(opDetail);
			
			if (newOPDetail != null) {
				apiResp.setStatus(200);
				apiResp.setMessage("Cập nhật thành công!");
				apiResp.setResult(newOPDetail);
			}
		}
		
		return apiResp;
	}
	
	@PutMapping("/api/recruitment/delete/option_detail")
	public ApiResponse<OptionDetail> deleteOPDetail(@RequestBody OptionDetail opDetail){
		
		ApiResponse<OptionDetail> apiResp = new ApiResponse<>(0, null, null, null, null);
		
		OptionDetail newOPDetail = detailService.update(opDetail);
		
		if (newOPDetail != null) {
			apiResp.setStatus(200);
			apiResp.setMessage("Xóa thành công!");
		}
		
		return apiResp;
	}
}
