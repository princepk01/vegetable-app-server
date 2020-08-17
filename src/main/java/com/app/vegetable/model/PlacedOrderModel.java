package com.app.vegetable.model;

import java.util.List;

public class PlacedOrderModel {

	private int id;
	private int totalAmount;
	private int totalItem;
	private String deliveredStatus;
	private AddressModel addressModel;
	private UserModel userModel;
	private List<OrderDetailsModel> orderDetailsModelList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public String getDeliveredStatus() {
		return deliveredStatus;
	}

	public void setDeliveredStatus(String deliveredStatus) {
		this.deliveredStatus = deliveredStatus;
	}

	public AddressModel getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public List<OrderDetailsModel> getOrderDetailsModelList() {
		return orderDetailsModelList;
	}

	public void setOrderDetailsModelList(List<OrderDetailsModel> orderDetailsModelList) {
		this.orderDetailsModelList = orderDetailsModelList;
	}

}
