package com.training.WebsiteEcommerce.controller;
import com.training.WebsiteEcommerce.model.Product;


import java.sql.SQLException;
import java.util.List;



public class ProductController implements IProductController<Product> {
	
	private static ProductController productController;
	private ProductCollection productCollection;
	private ProductController() {
		super();
		this.productCollection=ProductCollection.getProductCollection();
	}
	public static ProductController getProductCollection() {
		if(productController==null) {
			synchronized (ProductController.class) {
				if(productController==null) {
					productController= new ProductController();
				}
				
			}
		}
		return productController;
	}

	public List<Product> findAll() throws SQLException {
		return productCollection.findAll();
	}
	public Product findOne(int id) throws SQLException {
		return productCollection.findOne(id);
	}
	public boolean createNew(Product customer) throws SQLException {
		return productCollection.createNew(customer);
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		return productCollection.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Product customer) throws SQLException {
		return productCollection.findOneAndUpdate(id, customer);
	}
}