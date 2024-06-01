package com.recruitment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "auth/login.html";
	}
	
	@RequestMapping("/404")
	public String error404() {
        return "error";
    }
}
