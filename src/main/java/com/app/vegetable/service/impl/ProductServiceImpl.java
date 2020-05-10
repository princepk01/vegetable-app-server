package com.app.vegetable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.ProductBusiness;
import com.app.vegetable.jpa.Product;
import com.app.vegetable.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductBusiness productBusiness;
	
	@Override
	public Product saveProduct(Product product) {
		return productBusiness.saveProduct(product);
	}

	@Override
	public Product getProductById(int productId) {
		return productBusiness.getProductById(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		return productBusiness.getAllProduct();
	}

	@Override
	public void deleteProductById(int productId) {
		productBusiness.deleteProductById(productId);
		
	}

}
