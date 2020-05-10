package com.app.vegetable.service;

import java.util.List;

import com.app.vegetable.jpa.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public Product getProductById(int productId);

	public List<Product> getAllProduct();

	public void deleteProductById(int productId);

	
}
