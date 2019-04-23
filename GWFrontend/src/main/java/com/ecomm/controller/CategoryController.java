package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping(value="/category")
	public String showCategory(Model m)
	{
		System.out.println("In Category Controller");
		m.addAttribute("title", "Category");
		return "Category";
	}
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(@RequestParam("catName")String catName,@RequestParam("catDesc")String catDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryName(catName);
		category.setCategoryDesc(catDesc);
		
		categoryDAO.addCategory(category);
		
		m.addAttribute("title", "Category");
		return "Category";
	}
}