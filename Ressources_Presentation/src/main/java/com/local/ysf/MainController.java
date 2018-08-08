package com.local.ysf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/table")
	public String hello() {
		// TODO Auto-generated method stub
		return "table";
	}
	
	@RequestMapping("/hello")
	public String table(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("name","youssef");
		return "index";
	}
}
