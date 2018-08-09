package com.local.ysf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	
	@RequestMapping("/table")
	public String hello() {
		// TODO Auto-generated method stub
		return "home";
	}
	
	@RequestMapping("/hello")
	public ModelAndView table(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("name","youssef");
		return new ModelAndView("index");
	}
}
