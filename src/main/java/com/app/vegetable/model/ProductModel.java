package com.app.vegetable.model;

import java.util.List;

import com.app.vegetable.jpa.ProductItem;

public class ProductModel {

	private int id;
	private String productName;
	/*
	 * private byte[] productImage; private String productImageFileName;
	 */
	private String productImageUrl;
	private List<ProductItem> productItemList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/*
	 * public byte[] getProductImage() { return productImage; }
	 * 
	 * public void setProductImage(byte[] productImage) { this.productImage =
	 * productImage; }
	 * 
	 * public String getProductImageFileName() { return productImageFileName; }
	 * 
	 * public void setProductImageFileName(String productImageFileName) {
	 * this.productImageFileName = productImageFileName; }
	 */

	public List<ProductItem> getProductItemList() {
		return productItemList;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public void setProductItemList(List<ProductItem> productItemList) {
		this.productItemList = productItemList;
	}

}
