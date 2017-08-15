package com.ssm.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.Imp.IAdminService;

@Controller
@RequestMapping("/Account")
public class AccountController {
	
	@Resource
	private IAdminService service;
	
	@RequestMapping("/Index")
	public String Index(Model model) {
		model.addAttribute("accounts",service.findAccounts());
		return "Index";
	}
}
