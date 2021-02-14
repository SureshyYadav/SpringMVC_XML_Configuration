package com.javatechnology.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatechnology.model.Register;
import com.javatechnology.service.MyUserDetailsService;
import com.javatechnology.service.RegisterService;

@Controller
public class HomeController {
	@Autowired
	private RegisterService service;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@RequestMapping("/")
	public String homePage(@ModelAttribute("register") Register register) {
		System.out.println("homePage is called");
		return "register";
		
	}
	@RequestMapping(value="/registerProcess",method=RequestMethod.POST)
	public ModelAndView registerProcess(@Valid @ModelAttribute("register") Register register,BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("register");
		}else {
		ModelAndView view=new ModelAndView("home");
		service.saveRegister(register);
		System.out.println(register.getUsername());
		view.addObject("register", "Registration Process Success");
		return view;
		}
	}
	@RequestMapping("/home")
	public String loginPage() {
		return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam("username") String username) {
		userDetailsService.loadUserByUsername(username);
		ModelAndView view=new ModelAndView("welcome");
		view.addObject("register", "Registration Process Success");
		return view;
	}
	
	

}
