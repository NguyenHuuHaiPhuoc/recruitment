package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.Jobs;
import com.recruitment.service.JobService;

@CrossOrigin("*")
@RestController
//@RequestMapping("")
public class JobRestController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping("/api/recruitment/jobs/account_id={id}")
	public ApiResponse<Jobs> findAll(@PathVariable("id") String id){
		ApiResponse<Jobs> apiResp = new ApiResponse<>(0, null, null, null, null);
		List<Jobs> listJobs = jobService.getJob(id);
		
		if (listJobs != null) {
			apiResp.setStatus(200);
			apiResp.setMessage("Danh sách công việc.");
			apiResp.setListResult(listJobs);
		}
		return apiResp;
	}
	
	@GetMapping("/api/recruitment/jobs/id={id}")
	public ApiResponse<Jobs> findJobById(@PathVariable ("id") Integer id) {
		ApiResponse<Jobs> apiResp = new ApiResponse<>(0, null, null, null, null);
		Jobs job = jobService.findById(id);
		
		if (job == null) {
			apiResp.setStatus(404);
			apiResp.setMessage("Công việc không tìm thấy!");
		} else {
			apiResp.setStatus(200);
			apiResp.setMessage("Công việc chi tiết!");
			apiResp.setResult(job);
		}
		return apiResp;
	}
	
	@PostMapping("/api/recruitment/jobs")
	public ApiResponse<Jobs> createJob(@RequestBody Jobs job) {
		ApiResponse<Jobs> apiResp = new ApiResponse<>(0, null, job, null, null);
		Jobs newJob = jobService.create(job);
		
		if (newJob != null) {
			apiResp.setStatus(200);
			apiResp.setMessage("Tạo mới công việc thành công!");
			apiResp.setResult(newJob);
		}
		return apiResp;
	}
}
