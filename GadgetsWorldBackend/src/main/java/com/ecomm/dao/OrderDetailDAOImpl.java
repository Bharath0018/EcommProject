package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean paymentProcess(OrderDetail orderDetail) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	
	@Transactional
	@Override
	public boolean updateCartItemStatus(String username) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Cart set pstatus='P' where username=:uname");
		query.setParameter("uname", username);

		int row_eff = query.executeUpdate();

		if (row_eff > 0)
			return true;
		else
			return false;
	}

	@Transactional
	@Override
	public boolean updateOrderDetail(String username, int orderId) 
	{
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Cart set orderId=:oid where username=:uname and pstatus='NP'");
		query.setParameter("uname", username);
		query.setParameter("oid", orderId);

		int row_eff = query.executeUpdate();

		if (row_eff > 0)
			return true;
		else
			return false;
	}

}
