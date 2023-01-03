package com.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import com.ecommerce.model.Product;

public class ProductDaoTest {
	private Product product;
	private ProductDao productDao;
	@BeforeEach()
	public void beforeEach() {
		product=new Product(18,"laptop",5.6);
		productDao=new ProductDao();
	}
	@Disabled
	@Test
	public void testCreateProduct() {
		Assertions.assertTrue(productDao.createNew(product));
	}
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productDao.findAll());
	}
	@Disabled
	@Test
	public void testFindOneNotNull() {
		product=productDao.findOne(2);
		Assertions.assertNotNull(product);
		System.out.println("id=2 |"+product);
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productDao.findOneandDelete(2));
	}
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setpName("asjw");
		Assertions.assertTrue(productDao.findOneandUpdate(1, product));
	}
}
