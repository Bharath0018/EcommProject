package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.model.OrderDetail;

public class OrderDetailDAOTest 
{

static OrderDetailDAO orderDetailDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		orderDetailDAO=(OrderDetailDAO)context.getBean("orderDetailDAO");
	}
	
	@Test
	public void paymentProcessTest()
	{
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setUsername("prashanth");
		orderDetail.setAmount(50000);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPmode("CC");
		
		assertTrue("Problem in Order Processing",orderDetailDAO.paymentProcess(orderDetail));
		
		orderDetailDAO.updateCartItemStatus("prashanth");
		orderDetailDAO.updateOrderDetail("prashanth", orderDetail.getOrderId());
	}
}


