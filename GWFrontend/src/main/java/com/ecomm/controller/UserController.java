package com.ecomm.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Controller
public class UserController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/login_success", method=RequestMethod.POST)
	public String loginSuccess(HttpSession session, Model m)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		
		System.out.println("Hi "+username);
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		session.setAttribute("categoryList", categoryList);
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_USER"))
			{
				loggedIn=true;
				page="UserHome";
				session.setAttribute("username", username);
				session.setAttribute("loggedIn", loggedIn);
				
			}
			else 
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("username", username);
				session.setAttribute("loggedIn", loggedIn);
			}
		}
		
		return page;
	}
	
	@RequestMapping(value="/perform_logout")
	public String loggingOut(HttpSession session)
	{
		session.invalidate();
		return "Login";
	}
	
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")UserDetail user1,Model m)
	{
		/*UserDetail user=new UserDetail();*/
		
		user1.setRole("ROLE_USER");
		user1.setEnabled(true);
		user1.setPassword(passwordEncoder.encode(user1.getPassword()));
		userDAO.registerUser(user1);
		
		return "Login";
	}
}
