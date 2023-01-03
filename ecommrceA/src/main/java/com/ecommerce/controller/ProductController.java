package com.ecommerce.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.model.Product;


public class ProductController implements IController<Product> {
	private static ProductController productController;
	private ProductCollection productCollection;
	public ProductController() {
		super();
		this.productCollection=ProductCollection.getProductCollection();
	}
	public static ProductController getProductController() {
		if(productController==null) {
			synchronized (ProductController.class) {
				if(productController==null) {
					productController= new ProductController();
				}
				
			}
		}
		return productController;
	}


	@Override
	public List<Product> findAll() throws SQLException {
		return productCollection.findAll();
	}

	@Override
	public Product findOne(int id) throws SQLException {
		return productCollection.findOne(id);
	}

	@Override
	public boolean createNew(Product product) throws SQLException {
		return productCollection.createNew(product);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return productCollection.findOneAndDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		return productCollection.findOneAndUpdate(id, product);
	}
	
//	public Product findByName(String name) throws SQLException {
//		return productCollection.findByName(name);
//	}
}
