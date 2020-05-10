package com.app.vegetable.business;

import java.util.List;

import com.app.vegetable.jpa.Product;

public interface ProductBusiness {

	public Product saveProduct(Product product);

	public Product getProductById(int productId);

	public List<Product> getAllProduct();

	public void deleteProductById(int productId);
}
