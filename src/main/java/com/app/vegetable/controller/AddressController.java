package com.app.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.vegetable.converter.JpaToModelConvertor;
import com.app.vegetable.converter.ModelToJpaConvertor;
import com.app.vegetable.jpa.Address;
import com.app.vegetable.model.AddressModel;
import com.app.vegetable.service.AddressService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "/address")
public class AddressController extends BaseController{

	@Autowired
	private AddressService addressService;
	
	@PostMapping(value = "/save-address")
	public ResponseEntity<?> saveAddress(@RequestBody AddressModel addressModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		Address address = ModelToJpaConvertor.getJpaObject(addressModel);
		addressService.saveAddress(address);
		if (addressModel.getId() == 0) {
			responseMessage.setMessage("Address saved successfully.");
		} else {
			responseMessage.setMessage("Address updated successfully.");
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-address-by-id/{addressId}")
	public ResponseEntity<?> getAddressById(@PathVariable("addressId") int addressId) {
		ResponseMessage responseMessage = new ResponseMessage();
		Address address = addressService.getAddressById(addressId);
		AddressModel addressModel = JpaToModelConvertor.getModelObject(address);
		if (addressModel != null) {
			responseMessage.setData(addressModel);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-address-by-user-id/{userId}")
	public ResponseEntity<?> getAddressByUserId(@PathVariable("userId") int userId) {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Address> addressList = addressService.getAddressByUserId(userId);
		if(addressList != null && !addressList.isEmpty()) {
			List<AddressModel> addressModel = JpaToModelConvertor.getModelListAddressObject(addressList);
			if (addressModel != null) {
				responseMessage.setData(addressModel);
			}
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-all-address")
	public ResponseEntity<?> getAllAddress() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Address> addressList = addressService.getAllAddress();
		if (addressList != null && !addressList.isEmpty()) {
			List<AddressModel> addressModelList = JpaToModelConvertor.getModelListAddressObject(addressList);
			responseMessage.setData(addressModelList);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/delete-address-by-id/{addressId}")
	public ResponseEntity<?> deleteAddressById(@PathVariable("addressId") int addressId) {
		ResponseMessage responseMessage = new ResponseMessage();
		 addressService.deleteAddressById(addressId);
		 responseMessage.setMessage("Address deleted Successfully.");
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
}
