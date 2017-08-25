package com.ssm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestController {
	@RequestMapping("/test")
	public String classLoader() {
		System.out.println("-----begin----");
		ClassLoader loader=TestController.class.getClassLoader();
		while(loader!=null) {
			System.out.println(loader);
			loader=loader.getParent();
		}
		System.out.println(loader);
		System.out.println("-----end----");
		return null;
	} 
}
