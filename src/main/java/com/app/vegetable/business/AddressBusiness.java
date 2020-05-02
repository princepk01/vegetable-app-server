package com.app.vegetable.business;

import java.util.List;

import com.app.vegetable.jpa.Address;

public interface AddressBusiness {

	public Address saveAddress(Address address);

	public Address getAddressById(int addressId);

	public List<Address> getAllAddress();

	public void deleteAddressById(int addressId);

	public List<Address> getAddressByUserId(int userId);
}
