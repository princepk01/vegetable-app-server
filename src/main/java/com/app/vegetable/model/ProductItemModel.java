package com.app.vegetable.model;

public class ProductItemModel {

	private int id;
	private int productId;
	private String itemName;
	private int totalQuantity;
	private int totalPrice;
	private int itemMrp;
	private int discountPrice;
	private int remainingQuantity;
	private int totalSellQuantity;
	private int quantitySellAmount;
	private ProductItemDetailsModel productItemDetailsModel;
	private ProductItemImageModel productItemImageModel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getItemMrp() {
		return itemMrp;
	}

	public void setItemMrp(int itemMrp) {
		this.itemMrp = itemMrp;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public int getTotalSellQuantity() {
		return totalSellQuantity;
	}

	public void setTotalSellQuantity(int totalSellQuantity) {
		this.totalSellQuantity = totalSellQuantity;
	}

	public int getQuantitySellAmount() {
		return quantitySellAmount;
	}

	public void setQuantitySellAmount(int quantitySellAmount) {
		this.quantitySellAmount = quantitySellAmount;
	}

	public ProductItemImageModel getProductItemImageModel() {
		return productItemImageModel;
	}

	public void setProductItemImageModel(ProductItemImageModel productItemImageModel) {
		this.productItemImageModel = productItemImageModel;
	}

	public ProductItemDetailsModel getProductItemDetailsModel() {
		return productItemDetailsModel;
	}

	public void setProductItemDetailsModel(ProductItemDetailsModel productItemDetailsModel) {
		this.productItemDetailsModel = productItemDetailsModel;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
