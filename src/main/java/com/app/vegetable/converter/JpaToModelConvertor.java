package com.app.vegetable.converter;

import java.util.ArrayList;
import java.util.List;

import com.app.vegetable.jpa.Address;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.AddressModel;
import com.app.vegetable.model.UserModel;

public class JpaToModelConvertor {

	public static UserModel getModelObject(User user) {
		UserModel userModel = null;
		if (user != null) {
			userModel = new UserModel();

			userModel.setId(user.getId());
			userModel.setName(user.getName());
			userModel.setMobileNumber(user.getMobileNumber());
			userModel.setPassword(user.getPassword());
			userModel.setEmailAddress(user.getEmailAddress());
			userModel.setGender(user.getGender());
			userModel.setCreatedDate(user.getCreatedDate());
			userModel.setModifiedDate(user.getModifiedDate());
			userModel.setUserRole(user.getUserRole());
		}
		return userModel;
	}

	public static List<UserModel> getModelListObject(List<User> userList) {
		List<UserModel> userModelList = null;
		if (userList != null && !userList.isEmpty()) {
			userModelList = new ArrayList<UserModel>();
			for (User user : userList) {
				userModelList.add(getModelObject(user));
			}
		}
		return userModelList;
	}

	public static AddressModel getModelObject(Address address) {
		AddressModel addressModel = null;
		if (address != null) {
			addressModel = new AddressModel();

			addressModel.setId(address.getId());
			addressModel.setName(address.getName());
			addressModel.setMobileNumber(address.getMobileNumber());
			addressModel.setPinCode(address.getPinCode());
			addressModel.setAddress(address.getAddress());
			addressModel.setCity(address.getCity());
			addressModel.setState(address.getState());
			addressModel.setCreatedDate(address.getCreatedDate());
			addressModel.setModifiedDate(address.getModifiedDate());
		}
		return addressModel;
	}

	public static List<AddressModel> getModelListAddressObject(List<Address> addressList) {
		List<AddressModel> addressModelList = null;
		if (addressList != null && !addressList.isEmpty()) {
			addressModelList = new ArrayList<AddressModel>();
			for (Address address : addressList) {
				addressModelList.add(getModelObject(address));
			}
		}

		return addressModelList;
	}

	public static AddressModel getModelObject(List<Address> addressList) {
		
		return null;
	}

}
