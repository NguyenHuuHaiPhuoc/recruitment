package com.recruitment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.entity.Role;
import com.recruitment.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/recruitment")
public class RoleRestController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/role")
	public List<Role> findAll(){
		return roleService.findAll();
	}
}
