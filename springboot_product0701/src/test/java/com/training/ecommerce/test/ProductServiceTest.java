package com.training.ecommerce.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.ecommerce.dto.ProductData;
import com.training.ecommerce.service.ProductServicee;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductServicee productService;
	ProductData productData;

	@BeforeEach
	public void beforeEach() {
		productData = new ProductData();

		productData.setProductId(9l);
		productData.setProductName("laptop");
		productData.setProductDescription("this is ndskfnkdf");
		productData.setUnitPrice(23);
		productData.setImageUrl("1.sdjkskjpg");

	}

	@Test
	public void testFindAllNotNull() {
		assertNotNull(productService.findAll());
	}

	@Test
	public void testCreateNew() {
		assertNotNull(productService.create(productData));
	}

	@Test
	public void testFindOneNotNull() {
		Long id = 1l;
		assertNotNull(productService.findById(id));
	}

	@Test
	public void testFindOneAndDelete() {
		Long id = 2l;
		assertTrue(productService.delete(id));
	}

	@Test
	public void testFindOneAndUpdate() {
		Long id = 4l;
		assertNotNull(productService.updateProduct(productData, id));
	}

}
