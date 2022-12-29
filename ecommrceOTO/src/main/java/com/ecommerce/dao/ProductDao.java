package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.util.HibernateUtil;

public class ProductDao implements IDao<Product>{
	private Session session;
	private Transaction transaction;
	private Query query;
	public boolean createNew(Product product) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(product)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}


	public List<Product> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product");//select * from book
		final List<Product> productList=query.list();
		transaction.commit();
		return productList;
	}

	public Product findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Product p where p.pid="+id);
		final Product product=(Product) query.getSingleResult();
		transaction.commit();
		return product;
	}

	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Product p where p.pid=:id");
		query.setParameter("pid",id);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	public boolean findOneandUpdate(int id, Product newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Product p set p.pName=:pName where pid=:id");
		query.setParameter("pid",id);
		query.setParameter("pName",newObj.getpName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}




	

	
	
	
	

}
