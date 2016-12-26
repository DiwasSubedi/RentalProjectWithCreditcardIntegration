package com.himalayanGeeks.carRental.controller;

import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.himalayanGeeks.carRental.domain.User;
import com.himalayanGeeks.carRental.service.UserService;
import com.himalayanGeeks.carRental.serviceImpl.CustomUserDetailsService;

//HomeController defines which page to be opened at the begining of the application.
@Controller
@SessionAttributes("user")
public class HomeController {
	@Autowired
	CustomUserDetailsService cus;
	@Autowired
	UserService userservice;

	@RequestMapping(value = {"/","welcome"}, method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("inhomeget");
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} 
		else {
		  username = principal.toString();
		}
		System.out.println(username);
		User user = userservice.findByUsername(username);
		model.addAttribute("user", user);
		return "welcome";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("inhomeget");
		return "login";
	}
	
	/*@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String openAdmin() {
		System.out.println("inadminget");
		return "adminHome";
		/postLogin
	}*/
	/*
	@RequestMapping(value="/postLogin" , method= RequestMethod.GET)
	public String afterLogin(Model model) {
		 try{
	    		model.addAttribute("user", cus.getSessionUser());
	    		}
	    		catch(Exception e){
	    			throw e;
	    }
		System.out.println("after login" + cus.getSessionUser().getEmail());
 		return "redirect:/welcome";
 	}*/
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model,SessionStatus status,HttpSession session) {
		status.setComplete();
        session.removeAttribute("user");
 		return "redirect:/login";
 	}
	
	@RequestMapping(value="/denied", method = RequestMethod.GET)
	public String error(Model model) {
 		return "redirect:/error-forbidden";
 	}
	
	

}
