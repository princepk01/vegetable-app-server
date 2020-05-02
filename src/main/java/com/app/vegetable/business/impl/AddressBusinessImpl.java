package com.app.vegetable.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.AddressBusiness;
import com.app.vegetable.jpa.Address;
import com.app.vegetable.repository.AddressRepository;

@Service
public class AddressBusinessImpl implements AddressBusiness {

	@Autowired
	private AddressRepository addressRepostiory;
	
	@Override
	public Address saveAddress(Address address) {
		return addressRepostiory.save(address);
	}

	@Override
	public Address getAddressById(int addressId) {
		return addressRepostiory.getOne(addressId);
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepostiory.findAll();
	}

	@Override
	public void deleteAddressById(int addressId) {
		addressRepostiory.deleteById(addressId);
	}

	@Override
	public List<Address> getAddressByUserId(int userId) {
		return addressRepostiory.getAddressByUserId(userId);
	}

}
