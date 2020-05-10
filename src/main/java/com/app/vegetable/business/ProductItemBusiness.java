package com.app.vegetable.business;

import java.util.List;

import com.app.vegetable.jpa.ProductItem;

public interface ProductItemBusiness {

	public ProductItem saveProductItem(ProductItem productItem);

	public ProductItem getProductItemById(int productItemId);

	public List<ProductItem> getAllProductItem();

	public void deleteProductItemById(int productItemId);

	public List<ProductItem> getProductItemsByProductId(int productId);

	public List<ProductItem> getProductItemByProductName(String productName);
}
