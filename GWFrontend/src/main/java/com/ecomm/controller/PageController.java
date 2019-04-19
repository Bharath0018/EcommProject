package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
	@RequestMapping(value="/login")
	public String showLoginPage()
	{
		return "Login";
	}
	
	@RequestMapping(value="/register")
	public String showRegisterPage()
	{
		return "Register";
	}
	
	@RequestMapping(value="/")
	public String showHomePage()
	{
		return "Home";
	}
	

}
