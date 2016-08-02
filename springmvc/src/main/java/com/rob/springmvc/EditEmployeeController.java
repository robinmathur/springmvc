package com.rob.springmvc;


import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rob.model.Employee;
 
 
@Controller
public class EditEmployeeController {
 
 
 
    @RequestMapping(value = "/")
    public String defaultPage(ModelMap map) {
        return "redirect:/list";
    }
    @RequestMapping(value = "/list")
    public String listEmployees(ModelMap map) {
    	map.addAttribute("employee", new Employee(2,"Robin"));
 
        return "userDetail";
    }
    
    @RequestMapping(value = "/admin/adminConsole")
    public String adminConsole(ModelMap map) {
        return "adminConsole";
    }
 
   /* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(
            @ModelAttribute(value = "employee") EmployeeEntity employee,
            BindingResult result) {
        employeeManager.addEmployee(employee);
        return "redirect:/list";
    }
 
    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
        employeeManager.deleteEmployee(employeeId);
        return "redirect:/list";
    }*/
 
    @RequestMapping(value = "/login")
    public String login(ModelMap model) {
        return "login";
    }
 
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "denied";
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }
}
