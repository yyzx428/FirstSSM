package com.ssm.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.Imp.IAdminService;

@Controller
@RequestMapping("/Account")
public class AccountController {
	
	@Resource
	private IAdminService service;
	
	@RequestMapping("/IndexJson")
	@ResponseBody
	public Object IndexJson() {
		return service.findAccounts();
	}
	
	@RequestMapping("/Index")
	public Object Index(Model model) {
		model.addAttribute("accounts", service.findAccounts());
		return "Account\\Index";
	}
}
