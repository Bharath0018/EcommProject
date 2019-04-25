package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;


public class SupplierDAOTest 
{

static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier= new Supplier();
		supplier.setSupplierName("Om Enterprises");
		supplier.setSupplierDesc("We sell all kinds of electronics");
		
		assertTrue("Problem in Supplier Insertion:",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(33);
		assertTrue("Problem in Category Deletion:",supplierDAO.deleteSupplier(supplier));
		
	}
	
	
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(34);
		supplier.setSupplierDesc("We sell all kinds of mobile Devices");
		assertTrue("Problem in Category Updation:",supplierDAO.updateSupplier(supplier));
	}
	
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers = supplierDAO.listSupplier();
		assertTrue("Problem in Listing Categories:",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+"::");
			System.out.print(supplier.getSupplierName()+"::");
			System.out.println(supplier.getSupplierDesc());
		}
	}

}
