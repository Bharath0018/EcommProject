package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

public class ProductDAOTest 
{
static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Ignore
	@Test
	public void addProductTest() 
	{
		Product product=new Product();
		
		product.setProductName("Sony Headphones");
		product.setProductDesc("Headphones with built-in Mic and noise cancellation");
		product.setStock(25);
		product.setSupplierId(3);
		product.setCategoryId(3);
		product.setPrice(5000);
		
		assertTrue("Problem in Adding Category:",productDAO.addProduct(product));	
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Product product=productDAO.getProduct(8);
		assertTrue("Problem in Category Deletion:",productDAO.deleteProduct(product));
		
	}
	
	
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		assertTrue("Problem in Listing Category:",listProducts.size()>0);
		System.out.println("---AllProducts---");
		for(Product product:listProducts)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.print(product.getProductDesc()+":::");
			System.out.print(product.getStock()+":::");
			System.out.println(product.getPrice());
		}
	}
	
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(61);
		product.setProductDesc("1TB HDD,8 GB RAM,FullHD Screen,Dolby Audio");
		assertTrue("Problem in Product Updation:",productDAO.updateProduct(product));
	}
	
	
}
