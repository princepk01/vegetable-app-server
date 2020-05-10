package com.app.vegetable.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.ProductBusiness;
import com.app.vegetable.jpa.Product;
import com.app.vegetable.repository.ProductRepository;

@Service
public class ProductBusinessImpl implements ProductBusiness {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(int productId) {
		return productRepository.getOne(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public void deleteProductById(int productId) {
		productRepository.deleteById(productId);
		
	}

}
