package com.ecomm.dao;

import com.ecomm.model.OrderDetail;

public interface OrderDetailDAO 
{
	public boolean paymentProcess(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username);
	public boolean updateOrderDetail(String username, int orderId);

}
