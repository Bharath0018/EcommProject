package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("title", "Supplier");
		m.addAttribute("listSuppliers", supplierList);
		return "Supplier";
	}
	
	@RequestMapping(value="/addSupplier", method=RequestMethod.POST)
	public String addSupplier(@RequestParam("supName")String supName,@RequestParam("supDesc")String supDesc,Model m)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supName);
		supplier.setSupplierDesc(supDesc);
		
		supplierDAO.addSupplier(supplier);
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("listSuppliers", supplierList);
		m.addAttribute("title", "Supplier");
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId, Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("listSuppliers", supplierList);
		m.addAttribute("title", "Supplier");
		return "Supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")int supplierId, Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplier", supplier);
		m.addAttribute("title", "Supplier");
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/updateSupplier", method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("supid") int supplierId,@RequestParam("supName")String supName,@RequestParam("supDesc")String supDesc,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupplierName(supName);
		supplier.setSupplierDesc(supDesc);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("listSuppliers", supplierList);
		m.addAttribute("title", "Supplier");
		return "Supplier";
	}
}