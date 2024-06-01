package com.recruitment.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.ApiResponse;
import com.recruitment.entity.Account;
import com.recruitment.entity.Authority;
import com.recruitment.entity.Role;
import com.recruitment.service.AccountService;

@CrossOrigin("*")
@RestController
public class AccountRestController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/api/recruitment/account")
	public List<Account> findAll(){
		return accountService.findAll();
	}
	
	@GetMapping("/recruitment/login/username={username}&password={password}")
	public ApiResponse<Account> findUsername(
			@PathVariable("username") String username,
			@PathVariable("password") String password){
		ApiResponse<Account> apiResponse = new ApiResponse<>(0, null, null, null, null);
		Account account = accountService.findByAccount(username);
//		System.out.println(account);
		boolean passwordMatches = false;
		
		if (account == null) {
			apiResponse.setStatus(500);
			apiResponse.setMessage("Tài khoản không tồn tại!");
			apiResponse.setResult(null);
		} else {
			passwordMatches = bCryptPasswordEncoder.matches(password, account.getPassword());
			if (!passwordMatches) {
				apiResponse.setStatus(500);
				apiResponse.setMessage("Sai mật khẩu!");
				apiResponse.setResult(null);
				
			} else {
				List<Authority> role = account.getAuthorities();
				Integer[] roleCode = new Integer[]{};
				
				for (Authority authority : role) {
					Role r = authority.getRole();
					roleCode = new Integer[]{r.getId()};
				}
				
				apiResponse.setStatus(200);
				apiResponse.setMessage("Đăng nhập thành công!");
				apiResponse.setResult(account);
				apiResponse.setRole(roleCode);
			}
		}
		return apiResponse;
	}
	
	@PostMapping("/recruitment/register")
	public ApiResponse<Account> create(@RequestBody Account account) {
		ApiResponse<Account> apiResponse = new ApiResponse<>(0, null, null, null, null);
		
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		Account newAccount = accountService.create(account);
		
		if (newAccount != null) {
			apiResponse.setStatus(200);
			apiResponse.setMessage("Đăng ký thành công!");
			apiResponse.setResult(account);
		}	
		
		return apiResponse;
	}
}
