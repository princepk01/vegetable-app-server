package com.app.vegetable.model;

public class OrderDetailsModel {

	private int id;
	private int orderPrice;
	private String itemImageUrl;
	private String itemName;
	private String unit;
	private int cartItemId;
	private CartItemModel cartItemModel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getItemImageUrl() {
		return itemImageUrl;
	}

	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public CartItemModel getCartItemModel() {
		return cartItemModel;
	}

	public void setCartItemModel(CartItemModel cartItemModel) {
		this.cartItemModel = cartItemModel;
	}

}
