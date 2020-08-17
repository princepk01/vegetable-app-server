package com.app.vegetable.business;

import java.util.List;

import com.app.vegetable.jpa.PlacedOrder;

public interface PlacedOrderBusiness {

	public PlacedOrder savePlacedOrder(PlacedOrder placedOrder);
	
	public PlacedOrder getPlacedOrderById(int placedOrderId);
	
	public List<PlacedOrder> getAllPlacedOrder();
	
	public void deletePlacedOrderById(int placedOrderId);
}
