package com.app.vegetable.model;

public class CartItemModel {

	private int id;
	// private int totalItemCount;
	private int itemCount;
//	private int userId;
//	private int productItemId;
//	private int productItemDetailsId;
//	private int productItemImageId;

	private int userId;

	private ProductItemModel productItemModel;

	private ProductItemDetailsModel productItemDetailsModel;

	private ProductItemImageModel productItemImageModel;

	private int totalItemCountDiscountPrice;

	private int totalItemCountMrpAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getTotalItemCount() {
//		return totalItemCount;
//	}
//
//	public void setTotalItemCount(int totalItemCount) {
//		this.totalItemCount = totalItemCount;
//	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ProductItemModel getProductItemModel() {
		return productItemModel;
	}

	public void setProductItemModel(ProductItemModel productItemModel) {
		this.productItemModel = productItemModel;
	}

	public ProductItemDetailsModel getProductItemDetailsModel() {
		return productItemDetailsModel;
	}

	public void setProductItemDetailsModel(ProductItemDetailsModel productItemDetailsModel) {
		this.productItemDetailsModel = productItemDetailsModel;
	}

	public ProductItemImageModel getProductItemImageModel() {
		return productItemImageModel;
	}

	public void setProductItemImageModel(ProductItemImageModel productItemImageModel) {
		this.productItemImageModel = productItemImageModel;
	}

	public int getTotalItemCountDiscountPrice() {
		return totalItemCountDiscountPrice;
	}

	public void setTotalItemCountDiscountPrice(int totalItemCountDiscountPrice) {
		this.totalItemCountDiscountPrice = totalItemCountDiscountPrice;
	}

	public int getTotalItemCountMrpAmount() {
		return totalItemCountMrpAmount;
	}

	public void setTotalItemCountMrpAmount(int totalItemCountMrpAmount) {
		this.totalItemCountMrpAmount = totalItemCountMrpAmount;
	}

}
