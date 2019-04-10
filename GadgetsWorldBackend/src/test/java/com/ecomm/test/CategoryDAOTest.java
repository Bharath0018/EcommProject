package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category= new Category();
		category.setCategoryName("Mobile Phones(Basic)");
		category.setCategoryDesc("Samsung j-660 with built-in radio");
		
		assertTrue("Problem in Category Insertion:",categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		assertTrue("Problem in Category Deletion:",categoryDAO.deleteCategory(category));
		
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(4);
		category.setCategoryDesc("Samsung j660 with built-in radio and 1.3MP Camera");
		assertTrue("Problem in Category Updation:",categoryDAO.updateCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories = categoryDAO.listCategory();
		assertTrue("Problem in Listing Categories:",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+"::");
			System.out.print(category.getCategoryName()+"::");
			System.out.println(category.getCategoryDesc());
		}
	}

}
