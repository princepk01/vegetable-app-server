package com.app.vegetable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.PlacedOrderBusiness;
import com.app.vegetable.jpa.PlacedOrder;
import com.app.vegetable.service.PlacedOrderService;

@Service
public class PlacedOrderServiceImpl implements PlacedOrderService {

	@Autowired
	private PlacedOrderBusiness placedOrderBusiness;
	
	@Override
	public PlacedOrder savePlacedOrder(PlacedOrder placedOrder) {
		return placedOrderBusiness.savePlacedOrder(placedOrder);
	}

	@Override
	public PlacedOrder getPlacedOrderById(int placedOrderId) {
		return placedOrderBusiness.getPlacedOrderById(placedOrderId);
	}

	@Override
	public List<PlacedOrder> getAllPlacedOrder() {
		return placedOrderBusiness.getAllPlacedOrder();
	}

	@Override
	public void deletePlacedOrderById(int placedOrderId) {
		placedOrderBusiness.deletePlacedOrderById(placedOrderId);
	}

}
