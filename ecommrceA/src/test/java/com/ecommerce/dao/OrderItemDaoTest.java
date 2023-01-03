package com.ecommerce.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;

public class OrderItemDaoTest {
	

	    private Product product;
	    private OrderItem orderItem;
	    private OrderItemDao orderItemDao;
	    private ProductDao productDao;

	 

//	    @BeforeEach()
//	    public void beforeEach() {
//	        productDao = new ProductDao();
//	        product = productDao.findOne(39);
//	        int quantity = 3;
//	     
//	       double totalPrize = quantity *  product.getUnitPrice();
//	        orderItem = new OrderItem(product, quantity,totalPrize);
//	        orderItemDao = new OrderItemDao();
//	    }

	    @Test
	    public void testCreateProduct() {
	        Assertions.assertTrue(orderItemDao.createNew(orderItem));
	    }

	 

	   
	    @Test
	    public void testFindAllNotNull() {
	        Assertions.assertNotNull(orderItemDao.findAll());
	    }

	 

	  
	    @Test
	    public void testFindOneNotNull() {
	        orderItem = orderItemDao.findOne(61);
	        Assertions.assertNotNull(orderItem);
	        System.out.println("id=6 |" + orderItem);
	    }

	 

	    @Disabled 
	    @Test
	    public void testFindOneAndDelete() {
	        Assertions.assertTrue(orderItemDao.findOneandDelete(64));
	    }

	 

	    
	    @Test
	    public void testFindOneAndUpdate() {
	        orderItem.setQuantity(12);;
	        Assertions.assertTrue(orderItemDao.findOneandUpdate(70, orderItem));
	    }

	 

	}
