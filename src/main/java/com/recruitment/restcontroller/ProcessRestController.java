package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.Process;
import com.recruitment.service.ProcessService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/recruitment")
public class ProcessRestController {
	
	@Autowired
	ProcessService processService;
	
	@PostMapping("/process")
	public Process create(@RequestBody Process process) {
		return processService.create(process);
	}
	
	@GetMapping("/process/id={id}")
	public ApiResponse<Process> findProcessByJobID(@PathVariable("id") Integer jobID) {
		ApiResponse<Process> apiResp = new ApiResponse<>(0, null, null, null, null);
		List<Process> listProcess = processService.processByJobId(jobID);
		
		if (listProcess == null) {
			apiResp.setStatus(404);
			apiResp.setMessage("Không có quy trình phỏng vấn nào!");
		} else {
			apiResp.setStatus(200);
			apiResp.setMessage("Quy trình phỏng vấn!");
			apiResp.setListResult(listProcess);
		}
		return apiResp;
	}
}
