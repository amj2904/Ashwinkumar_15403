package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.util.HibernateUtil;



public class CustomerDao implements IDao<Customer>{
	private Session session;
	private Transaction transaction;
	private Query query;
	public boolean createNew(Customer customer) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(customer)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}


	public List<Customer> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer");//select * from book
		final List<Customer> customerList=query.list();
		transaction.commit();
		return customerList;
	}

	public Customer findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer c where c.id="+id);
		final Customer customer=(Customer) query.getSingleResult();
		transaction.commit();
		return customer;
	}

	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Customer c where c.id=:id");
		query.setParameter("id",id);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	public boolean findOneandUpdate(int cid, Customer newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Customer c set c.cName=:cname where id=:id");
		query.setParameter("id",cid);
		query.setParameter("cname",newObj.getcName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}
	
	
	

}
