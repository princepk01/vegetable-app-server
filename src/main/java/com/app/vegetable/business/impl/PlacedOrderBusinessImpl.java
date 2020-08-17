package com.app.vegetable.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.PlacedOrderBusiness;
import com.app.vegetable.jpa.PlacedOrder;
import com.app.vegetable.repository.PlacedOrderRepository;

@Service
public class PlacedOrderBusinessImpl implements PlacedOrderBusiness {

	@Autowired
	private PlacedOrderRepository placedOrderRepository;
	
	@Override
	public PlacedOrder savePlacedOrder(PlacedOrder placedOrder) {
		return placedOrderRepository.save(placedOrder);
	}

	@Override
	public PlacedOrder getPlacedOrderById(int placedOrderId) {
		return placedOrderRepository.getOne(placedOrderId);
	}

	@Override
	public List<PlacedOrder> getAllPlacedOrder() {
		return placedOrderRepository.findAll();
	}

	@Override
	public void deletePlacedOrderById(int placedOrderId) {
		placedOrderRepository.deleteById(placedOrderId);
	}

}
