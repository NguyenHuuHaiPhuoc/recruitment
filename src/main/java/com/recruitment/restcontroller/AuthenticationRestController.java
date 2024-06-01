package com.recruitment.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.dto.AuthenticationDTO;
import com.recruitment.dto.AuthenticationResponse;
import com.recruitment.service.jwt.UserDetailServiceIplm;
import com.recruitment.util.JwtUtil;

@CrossOrigin("*")
@RestController
public class AuthenticationRestController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailServiceIplm userDetailServiceIplm;
	
	@PostMapping("/recruitment/authentication")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO) {
		final UserDetails userDetails = userDetailServiceIplm.loadUserByUsername(authenticationDTO.getUsername());
		
		String token = null;
		if (userDetails.getPassword().equals(authenticationDTO.getPassword())) {
			token = jwtUtil.generateToken(userDetails.getUsername());
		} 
		return new AuthenticationResponse(token);
	}
}
