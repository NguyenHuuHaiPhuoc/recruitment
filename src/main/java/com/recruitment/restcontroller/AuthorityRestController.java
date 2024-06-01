package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.entity.Authority;
import com.recruitment.service.AuthorityService;

@CrossOrigin("*")
@RestController
//@RequestMapping("/api/recruitment")
public class AuthorityRestController {
	
	@Autowired
	AuthorityService authorityService;
	
	@GetMapping("/api/recruitment/auth")
	public List<Authority> findAllAuthorities(){
		return authorityService.findAll();
	}
	
	@PostMapping("/recruitment/create/auth")
	public Authority createAuthorities(@RequestBody Authority authority){
		return authorityService.create(authority);
	}
}
