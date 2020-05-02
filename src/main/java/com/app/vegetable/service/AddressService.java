package com.app.vegetable.service;

import java.util.List;

import com.app.vegetable.jpa.Address;

public interface AddressService {

	public Address saveAddress(Address address);

	public Address getAddressById(int addressId);

	public List<Address> getAllAddress();

	public void deleteAddressById(int addressId);

	public List<Address> getAddressByUserId(int userId);
}
