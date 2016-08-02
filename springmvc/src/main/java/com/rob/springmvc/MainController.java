package com.rob.springmvc;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.rob.model.User;

@Controller
@SessionAttributes("hello")
public class MainController {
	Logger logger = Logger.getLogger("MainController");

	/*@ModelAttribute("hostwish")
	public String bewforAnyMethod() {
		logger.info("In ModelIttri");
		return "Hello Robin";
	}*/

	@RequestMapping(value = "/saveUser")
	/*
	 * @ResponseBody
	 * 
	 * @JsonView(value=User.FullDetail.class)
	 */
	public String saveUser(@ModelAttribute User user, BindingResult result, Model model,
			@RequestHeader Map<String, String> header,HttpSession session, @RequestHeader("accept") String[] acceptHeader) {
		if (result.hasErrors()) {
			logger.info("Error count  - " + result.getErrorCount());
		}
		logger.info("Is session = "+session.isNew());
		logger.info("Saved user - " + user);
		logger.info("Is test Contained - " + model.containsAttribute("test"));
		logger.info("Accept - " + Arrays.toString(acceptHeader));
		/*
		 * for(Map.Entry<String, String> entry : header.entrySet()){
		 * logger.info("Key -"+entry.getKey()+", Value - "+entry.getValue()); }
		 */
		 model.addAttribute("hello", "hello robin");
		return "userDetail";
	}

	@RequestMapping(value = "/jsonUser")
	@ResponseBody
	public User jsonUser(HttpSession session, HttpServletRequest request,HttpServletResponse response, SessionStatus status, @CookieValue("JSESSIONID") String sessionID) {
		logger.info("Session ID = "+sessionID);
		Cookie [] cookies = request.getCookies();
		for(Cookie coo : cookies){
			if(coo.getName().equals("JSESSIONID")){
				coo.setMaxAge(-1);
				response.addCookie(coo);
			}
		}
		logger.info("Hello from session = "+session.getAttribute("hello"));
		status.setComplete();
		logger.info("Is session = "+session.isNew());
		
		User user = new User();
		user.setFirstName("Satish");
		user.setLastName("Mathur");
		user.setAge(34);
		return user;
	}

	@RequestMapping(value = "/xmlUser", produces = "application/xml")
	@ResponseBody
	public User xmlUser(@RequestBody User userIn) {
		logger.info("In User = " + userIn);
		User user = new User();
		user.setFirstName("Satish");
		user.setLastName("Mathur");
		user.setAge(34);
		return user;

	}

}
