package com.app.vegetable.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.ProductItemBusiness;
import com.app.vegetable.jpa.Product;
import com.app.vegetable.jpa.ProductItem;
import com.app.vegetable.repository.ProductItemRepository;
import com.app.vegetable.repository.ProductRepository;

@Service
public class ProductItemBusinessImpl implements ProductItemBusiness {

	@Autowired
	private ProductItemRepository productItemRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductItem saveProductItem(ProductItem productItem) {
		return productItemRepository.save(productItem);
	}

	@Override
	public ProductItem getProductItemById(int productItemId) {
		return productItemRepository.getOne(productItemId);
	}

	@Override
	public List<ProductItem> getAllProductItem() {
		return productItemRepository.findAll();
	}

	@Override
	public void deleteProductItemById(int productItemId) {
		productItemRepository.deleteById(productItemId);

	}

	@Override
	public List<ProductItem> getProductItemsByProductId(int productId) {
		return productItemRepository.getProductItemsByProductId(productId);
	}

	@Override
	public List<ProductItem> getProductItemByProductName(String productName) {
		Product product = productRepository.findByProductName(productName);
		if(product != null) {
			return productItemRepository.getProductItemsByProductId(product.getId());
		}
		return null;
	}

}
