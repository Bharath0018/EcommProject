package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product1,Model m)
	{
		productDAO.addProduct(product1);
		
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		return "Product";
	}

}
