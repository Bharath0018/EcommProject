package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;



public class UserDAOTest 
{
	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("prashanth");
		user.setPassword("pass123");
		user.setEmailId("prashanth@gmail.com");
		user.setMobileNo("7776665554");
		user.setRole("ROLE_USER");
		user.setAddress("Bangalore");
		
		assertTrue("Problem in Registering User:",userDAO.registerUser(user));
		
	}
}
