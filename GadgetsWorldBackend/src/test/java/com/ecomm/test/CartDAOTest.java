package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;

public class CartDAOTest 
{
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	@Ignore
	@Test
	public void addCartTest()
	{
		Cart cartItem=new Cart();
		
		cartItem.setProductId(13);
		cartItem.setProductName("Sony Xperia XZ");
		cartItem.setPrice(43000);
		cartItem.setQuantity(2);
		cartItem.setPstatus("NP");
		cartItem.setUsername("prashanth");
		
		assertTrue("Problem in adding CartItem",cartDAO.addCartItem(cartItem));
	}
	
	@Test
	public void listCartItems()
	{
		List<Cart> cartItemList=cartDAO.listCartItems("prashanth");
		
		assertTrue("Problem in listing Cart Items",cartItemList.size()>0);
		
		for(Cart cart:cartItemList)
		{
			System.out.print(cart.getCartItemId()+":::");
			System.out.print(cart.getProductName()+":::");
			System.out.println(cart.getQuantity());
		}
	}
}
