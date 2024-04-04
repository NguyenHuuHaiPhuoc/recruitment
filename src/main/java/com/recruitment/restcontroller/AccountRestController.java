package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.entity.Account;
import com.recruitment.service.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/test")
public class AccountRestController {
	@Autowired
	AccountService aService;
	
	@GetMapping("/codes")
	public List<Account> findAll(){
		return aService.findAll();
	}
}
