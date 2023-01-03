package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Orders;
import com.ecommerce.util.HibernateUtil;

public class OrdersDao implements IDao<Orders> {
	private Session session;
    private Transaction transaction;
    private Query query;
    private Orders Orders;
    private  static OrdersDao ordersDao;
    
    public static OrdersDao getOrdersDao() {
		if (ordersDao == null) {
			synchronized (OrdersDao.class) {
				if (ordersDao == null) {
					ordersDao = new OrdersDao();
				}
			}
		}
		return ordersDao;
	}

    
    
	@Override
	public boolean createNew(Orders orders) {
		boolean result=false;
        session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
        transaction=session.beginTransaction();
        if(session.save(orders)!=null) {
            result=true;
        }        
        transaction.commit();
        return result;
    }

	@Override
	public List<Orders> findAll() {
		 session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
	        transaction=session.beginTransaction();
	        query=session.createQuery("from Orders");//select * from Customer
	        final List<Orders> orderList=query.list();
	        transaction.commit();
	        return orderList;
	    }

	@Override
	public Orders findOne(int id) {
		 session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
	        transaction=session.beginTransaction();
	        query=session.createQuery("from Orders o where o.orderId="+id);
	        final Orders order=(Orders) query.getSingleResult();
	        transaction.commit();
	        return order;
	    }

	@Override
	public boolean findOneandDelete(int id) {
		boolean result=false;
        session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
        transaction=session.beginTransaction();
        query=session.createQuery("Delete from Orders o where o.orderId=:id");
        query.setParameter("id",id);
        final int statusDelete=query.executeUpdate();        
        transaction.commit();
//        System.out.println("statusDeleted: "+statusDelete);
        if(statusDelete>0) {
            result=true;
        }
        return result;
    }

	@Override
	public boolean findOneandUpdate(int odid, Orders newObj) {
		 boolean result=false;
			session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
	        transaction=session.beginTransaction();
	        
	        query=session.createQuery("update Orders o set o.orderId=:custmer_id where o.oderid=:id");
	        query.setParameter("custmer_id",Orders.getOrderId());
	        query.setParameter("id", odid);
	        
	        final int statusUpdate=query.executeUpdate();        
	        transaction.commit();
	        if(statusUpdate>0) {
	            result=true;
	        }
	        return result;
	    }

	
	

}
