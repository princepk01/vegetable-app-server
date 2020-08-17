package com.app.vegetable.service;

import java.util.List;

import com.app.vegetable.jpa.PlacedOrder;

public interface PlacedOrderService {

	public PlacedOrder savePlacedOrder(PlacedOrder placedOrder);

	public PlacedOrder getPlacedOrderById(int placedOrderId);

	public List<PlacedOrder> getAllPlacedOrder();

	public void deletePlacedOrderById(int placedOrderId);
}
