package com.app.vegetable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.ProductItemBusiness;
import com.app.vegetable.jpa.ProductItem;
import com.app.vegetable.service.ProductItemService;

@Service
public class ProductItemServiceImpl implements ProductItemService {

	@Autowired
	private ProductItemBusiness productItemBusiness;
	
	@Override
	public ProductItem saveProductItem(ProductItem productItem) {
		return productItemBusiness.saveProductItem(productItem);
	}

	@Override
	public ProductItem getProductItemById(int productItemId) {
		return productItemBusiness.getProductItemById(productItemId);
	}

	@Override
	public List<ProductItem> getAllProductItem() {
		return productItemBusiness.getAllProductItem();
	}

	@Override
	public void deleteProductItemById(int productItemId) {
		productItemBusiness.deleteProductItemById(productItemId);
		
	}

	@Override
	public List<ProductItem> getProductItemsByProductId(int productId) {
		return productItemBusiness.getProductItemsByProductId(productId);
	}

	@Override
	public List<ProductItem> getProductItemByProductName(String productName) {
		return productItemBusiness.getProductItemByProductName(productName);
	}

}
