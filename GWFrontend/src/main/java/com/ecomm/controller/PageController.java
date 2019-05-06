package com.ecomm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Controller
public class PageController 
{
	@RequestMapping(value="/login")
	public String showLoginPage(Model m)
	{
		m.addAttribute("title", "Login Page");
		return "Login";
	}
	
	@RequestMapping(value="/register")
	public String showRegisterPage(Model m)
	{
		m.addAttribute("title", "Register Page");
		UserDetail user=new UserDetail();
		m.addAttribute("user", user);
		return "Register";
	}
	
	@RequestMapping(value="/")
	public String showHomePage()
	{
		return "Home";
	}
	

}