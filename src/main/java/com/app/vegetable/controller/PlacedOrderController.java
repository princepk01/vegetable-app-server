package com.app.vegetable.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.vegetable.converter.ModelToJpaConvertor;
import com.app.vegetable.jpa.PlacedOrder;
import com.app.vegetable.model.PlacedOrderModel;
import com.app.vegetable.service.PlacedOrderService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "/placed-order")
public class PlacedOrderController extends BaseController {

	@Autowired
	private PlacedOrderService placedOrderService;

	@PostMapping(value = "/save-placed-order")
	public ResponseEntity<?> savePlacedOrder(@RequestBody PlacedOrderModel placedOrderModel) throws IOException {

		ResponseMessage responseMessage = new ResponseMessage();
		if (placedOrderModel != null) {
			PlacedOrder placedOrder = ModelToJpaConvertor.getJpaObject(placedOrderModel);
			PlacedOrder order = placedOrderService.savePlacedOrder(placedOrder);
			responseMessage.setData(order);
			if (placedOrderModel.getId() == 0) {
				responseMessage.setMessage("Order placed successfully");
			} else {
				responseMessage.setMessage("Order updated successfully.");
			}
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

}
