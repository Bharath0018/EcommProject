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
		user.setUsername("niit");
		user.setPassword("niit@123");
		user.setEmailId("bharath@gmail.com");
		user.setMobileNo("9164694490");
		user.setRole("ROLE_ADMIN");
		user.setAddress("Mysore");
		user.setEnabled(true);
		
		assertTrue("Problem in Registering User:",userDAO.registerUser(user));
		
	}
}
