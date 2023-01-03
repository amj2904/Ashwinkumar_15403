package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

public class ProductCollection implements ICollection<Product> {
	private static ProductCollection productCollection;
	private static ProductDao productDao;
	private List<Product> productList;

//	public static ProductDao getProductDao() {
//		if (productDao == null) {
//			synchronized (ProductDao.class) {
//				if (productDao == null) {
//					productDao = new ProductDao();
//				}
//			}
//		}
//		return productDao;
//	}
	private ProductCollection() {
		super();
		this.productDao=ProductDao.getProductDao();
	}
	

	public static ProductCollection getProductCollection() {
		if (productCollection == null) {
			synchronized (ProductCollection.class) {
				if (productCollection == null) {
					productCollection = new ProductCollection();
				}

			}
		}
		return productCollection;
	}

	

	@Override
	public List<Product> findAll() throws SQLException {
		productList = productDao.findAll();
		return productList;
	}

	@Override
	public Product findOne(int id) throws SQLException {
		Product product = productDao.findOne(id);
		return product;
	}

	@Override
	public boolean createNew(Product product) throws SQLException {
		return productDao.createNew(product);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return productDao.findOneandDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		return productDao.findOneandUpdate(id, product);
	}
	
//	public Product findByName(String name) throws SQLException {
//		Product product = productDao.findByName(name);
//		return product;
//	}
}
