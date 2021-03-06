package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;

@Controller
public class CartController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/showCart")
	public String showCart(Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		session.setAttribute("cartSize",new Integer(cartItemList.size()));
		
		return "Cart";
	}
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity, Model m, HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		Cart cartItem=new Cart();
		
		String username=(String)session.getAttribute("username");
		
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setUsername(username);
		cartItem.setPstatus("NP");
		
		cartDAO.addCartItem(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		session.setAttribute("cartSize",new Integer(cartItemList.size()));
		
		return "Cart";
	}
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		session.setAttribute("cartSize",new Integer(cartItemList.size()));
		
		return "Cart";
	}
	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId, Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		session.setAttribute("cartSize",new Integer(cartItemList.size()));
		
		return "Cart";
	}
	public int getGrandTotal(List<Cart> cartItemList)
	{
		int grandTotal=0;
		
		int count=0;
		
		while(count<cartItemList.size())
		{
			Cart cartItem=cartItemList.get(count);
			grandTotal=grandTotal+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
		}
		
		return grandTotal;		
	}
	
	@RequestMapping(value="/checkout")
	public String showOrderConfirm(Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		session.setAttribute("cartSize", new Integer(cartItemList.size()));
		
		return "OrderConfirm";
	}

}
