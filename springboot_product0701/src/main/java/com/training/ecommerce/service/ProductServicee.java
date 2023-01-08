package com.training.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.ecommerce.dao.IProductRepository;
import com.training.ecommerce.dto.ProductData;
import com.training.ecommerce.model.Product;

@Service
public class ProductServicee implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	// DTO=>Entity
	private Product getProductEntity(ProductData productData) {
		Product product = new Product();
		product.setProductId(productData.getProductId());
		product.setProductName(productData.getProductName());
		product.setProductDescription(productData.getProductDescription());
		product.setUnitPrice(productData.getUnitPrice());
		product.setImageUrl(productData.getImageUrl());
		return product;
	}

//	Entity=>DTO
	private ProductData getProductData(Product product) {
		ProductData productData = new ProductData();
		productData.setProductId(product.getProductId());
		productData.setProductName(product.getProductName());
		productData.setProductDescription(product.getProductDescription());
		productData.setUnitPrice(product.getUnitPrice());
		productData.setImageUrl(product.getImageUrl());

		return productData;

	}

	@Override
	public List<ProductData> findAll() {

		List<ProductData> productDataList = new ArrayList<>();
		List<Product> products = productRepository.findAll();
		products.forEach(product -> {
			productDataList.add(getProductData(product));
		});
		return productDataList;

	}

	@Override
	public ProductData findById(Long id) {

		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional == null) {
			new EntityNotFoundException("Product Not Found");
		}
		return getProductData(productOptional.get());
	}

	@Override
	public ProductData create(ProductData productData) {

		Product product = getProductEntity(productData);
		return getProductData(productRepository.save(product));
	}

	@Override
	public boolean delete(Long id) {

		Product product = productRepository.findById(id).get();
		if (product != null) {
			productRepository.deleteById(id);
			return true;

		} else {
			return false;
		}

	}

	public ProductData updateProduct(ProductData productData, Long productId) {
		Product product2 = productRepository.findById(productId).get();
		if (product2 != null) {
			product2.setProductName(productData.getProductName());
			product2.setProductDescription(productData.getProductDescription());
			product2.setUnitPrice(productData.getUnitPrice());
			product2.setImageUrl(productData.getImageUrl());
			productRepository.save(product2);
			return getProductData(product2);
		} else {
			return null;
		}

	}

}
