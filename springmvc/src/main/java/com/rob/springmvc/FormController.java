package com.rob.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rob.model.Employee;
import com.rob.model.User;

@Controller
public class FormController {

	@RequestMapping(value="/form")
	public void getForm(@ModelAttribute("user") User user, @ModelAttribute("emp") Employee emp) {
		
		System.out.println(user);
		System.out.println(emp);
	}
	@RequestMapping(value="/home")
	public String home(Model model){
		return "classpath:resources/templates/home";
	}
}
