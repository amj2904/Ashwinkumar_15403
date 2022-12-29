package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.OrderItem;
import com.ecommerce.util.HibernateUtil;

public class OrderItemDao implements IDao<OrderItem> {
	   private Session session;
	    private Transaction transaction;
	    private Query query;

	
	public boolean createNew(OrderItem orderItem) {
		 boolean result=false;
	        session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
	        transaction=session.beginTransaction();
	        if(session.save(orderItem)!=null) {
	            result=true;
	        }        
	        transaction.commit();
	        return result;
	    }
	public List<OrderItem> findAll() {
		   session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
	        transaction=session.beginTransaction();
	        query=session.createQuery("from OrderItem");//select * from Customer
	        final List<OrderItem> OrderItemList=query.list();
	        transaction.commit();
	        return OrderItemList;
	    }

	
	public OrderItem findOne(int id) {
		   session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
	        transaction=session.beginTransaction();
	        query=session.createQuery("from OrderItem o where o.itemId="+id);
	        final OrderItem orderItem=(OrderItem) query.getSingleResult();
	        transaction.commit();
	        return orderItem;
	    }

	
	public boolean findOneandDelete(int id) {
		  boolean result=false;
	        session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
	        transaction=session.beginTransaction();
	        query=session.createQuery("Delete from OrderItem o where o.itemId=:id");
	        query.setParameter("id",id);
	        final int statusDelete=query.executeUpdate();        
	        transaction.commit();
//	        System.out.println("statusDeleted: "+statusDelete);
	        if(statusDelete>0) {
	            result=true;
	        }
	        return result;
	    }

	
	public boolean findOneandUpdate(int odid, OrderItem orderItem) {
	     boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
        transaction=session.beginTransaction();
        //query=session.createQuery("Update orderitem o set o.quantity=:pquantity where o.itemid=:pid");
        //query.setParameter("pid",id);
        //query.setParameter("pquantity",newObj.getQuantity());
        query=session.createQuery("update OrderItem o set o.quantity=:odquantity where o.itemId=:id");
        query.setParameter("odquantity",orderItem.getQuantity());
        query.setParameter("id", odid);
        
        final int statusUpdate=query.executeUpdate();        
        transaction.commit();
        if(statusUpdate>0) {
            result=true;
        }
        return result;
    }

 

}