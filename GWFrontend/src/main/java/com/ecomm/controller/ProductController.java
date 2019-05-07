package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		List<Category> categoryList=categoryDAO.listCategory();
		/*m.addAttribute("categoryList", categoryList);*/
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		List<Supplier> supplierList=supplierDAO.listSupplier();
		/*m.addAttribute("supplierList", supplierList);*/
		m.addAttribute("supplierList", this.getSupplierList(supplierList));
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap categoryList1=new LinkedHashMap();
		int i=0;
		while(i<categoryList.size())
		{
			Category category=categoryList.get(i);
			categoryList1.put(category.getCategoryId(),category.getCategoryName());
			i++;
		}
		return categoryList1;
	}
	
	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> supplierList)
	{
		LinkedHashMap supplierList1=new LinkedHashMap();
		int i=0;
		while(i<supplierList.size())
		{
			Supplier supplier=supplierList.get(i);
			supplierList1.put(supplier.getSupplierId(),supplier.getSupplierName());
			i++;
		}
		return supplierList1;
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product1,@RequestParam("pimage") MultipartFile fileImage,Model m)
	{
		productDAO.addProduct(product1);
		
		String path="D:\\EcommProject\\EcommProject-master\\GWFrontend\\src\\main\\webapp\\resources\\images\\";
		
		path=path+String.valueOf(product1.getProductId())+".jpg";
		
		File image=new File(path);
		
		if(!fileImage.isEmpty())
		{
			try
			{
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("ErrorInfo", e.getMessage());
			}
		}
		else
		{
			m.addAttribute("ErrorInfo", "Problem Occured");
		}
		
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "redirect:/productList";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId, Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "redirect:/productList";
	}
	
	@RequestMapping(value="/UpdateProduct/{productId}" ,method=RequestMethod.POST )
	public String updateProduct(@PathVariable("productId")int productId,@ModelAttribute("product")Product product1,Model m)
	{
		System.out.println("Im in update controller");
		productDAO.updateProduct(product1);
		System.out.println("Im in update method");
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
	/*	List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		*/
		return "redirect:/productList";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId, Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSupplierList(supplierList));
		
		return "UpdateProduct";
	}
	
	
	
	@RequestMapping(value="/totalProductDisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId, Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product", product);
		return "TotalProductDisplay";
	}
	
	@RequestMapping(value="/productDisplay")
	public String productDisplay(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/productList")
	public String showProductList(Model m)
	{

		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		m.addAttribute("title", "Product List");
		return "ProductList";
	}


}
