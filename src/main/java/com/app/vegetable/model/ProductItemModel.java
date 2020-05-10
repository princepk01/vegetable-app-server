package com.app.vegetable.model;

public class ProductItemModel {

	private int id;
	private int productId;
	private String itemName;
	private String totalQuantity;
	private String totalPrice;
	private String itemMrp;
	private String discountPrice;
	private String remainingQuantity;
	private String totalSellQuantity;
	private String quantitySellAmount;
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

	public String getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getItemMrp() {
		return itemMrp;
	}

	public void setItemMrp(String itemMrp) {
		this.itemMrp = itemMrp;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(String remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public String getTotalSellQuantity() {
		return totalSellQuantity;
	}

	public void setTotalSellQuantity(String totalSellQuantity) {
		this.totalSellQuantity = totalSellQuantity;
	}

	public String getQuantitySellAmount() {
		return quantitySellAmount;
	}

	public void setQuantitySellAmount(String quantitySellAmount) {
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
