package com.app.vegetable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.AddressBusiness;
import com.app.vegetable.jpa.Address;
import com.app.vegetable.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressBusiness addressBusiness;
	
	@Override
	public Address saveAddress(Address address) {
		return addressBusiness.saveAddress(address);
	}

	@Override
	public Address getAddressById(int addressId) {
		return addressBusiness.getAddressById(addressId);
	}

	@Override
	public List<Address> getAllAddress() {
		return addressBusiness.getAllAddress();
	}

	@Override
	public void deleteAddressById(int addressId) {
		addressBusiness.deleteAddressById(addressId);
	}

	@Override
	public List<Address> getAddressByUserId(int userId) {
		return addressBusiness.getAddressByUserId(userId);
	}

}
