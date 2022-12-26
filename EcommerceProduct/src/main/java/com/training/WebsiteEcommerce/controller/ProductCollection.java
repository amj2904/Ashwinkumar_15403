package com.training.WebsiteEcommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.WebsiteEcommerce.dao.ProductDao;
import com.training.WebsiteEcommerce.model.Product;



public class ProductCollection implements IProductCollection<Product> {
	
	
	private static ProductCollection productCollection;
	private ProductDao dao;
	private List<Product> productList;
	
	private ProductCollection() {
		this.dao=ProductDao.getProductDao();
	}
	public static ProductCollection getProductCollection() {
		if(productCollection==null) {
			synchronized (ProductCollection.class) {
				if(productCollection==null) {
					productCollection=new ProductCollection();
				}
				
			}
		}
		return productCollection;
	}
	

	public List<Product> findAll() throws SQLException {
		productList=dao.findAll();
		return productList;
	}

	public Product findOne(int id) throws SQLException {
		Product product=dao.findOne(id);
		return product;
	}

	public boolean createNew(Product product) throws SQLException {
		return dao.createNew(product);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		return dao.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		return dao.findOneAndUpdate(id, product);
	}

}
