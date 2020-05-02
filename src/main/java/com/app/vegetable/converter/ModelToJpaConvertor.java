package com.app.vegetable.converter;

import com.app.vegetable.jpa.Address;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.AddressModel;
import com.app.vegetable.model.UserModel;

public class ModelToJpaConvertor {

	public static User getJpaObject(UserModel userModel) {
		User user = null;
		if (userModel != null) {
			user = new User();

			user.setId(userModel.getId());
			user.setName(userModel.getName());
			user.setMobileNumber(userModel.getMobileNumber());
			user.setPassword(userModel.getPassword());
			user.setEmailAddress(userModel.getEmailAddress());
			user.setGender(userModel.getGender());
			user.setCreatedDate(userModel.getCreatedDate());
			user.setModifiedDate(userModel.getModifiedDate());
			user.setUserRole(userModel.getUserRole());
		}
		return user;
	}

	public static Address getJpaObject(AddressModel addressModel) {
		Address address = null;
		if (addressModel != null) {
			address = new Address();

			address.setId(addressModel.getId());
			address.setName(addressModel.getName());
			address.setMobileNumber(addressModel.getMobileNumber());
			address.setPinCode(addressModel.getPinCode());
			address.setAddress(addressModel.getAddress());
			address.setCity(addressModel.getCity());
			address.setState(addressModel.getState());
			address.setCreatedDate(addressModel.getCreatedDate());
			address.setModifiedDate(addressModel.getModifiedDate());
			int userId = addressModel.getUserId();
			if(userId != 0) {
				User user = new User();
				user.setId(userId);
				address.setUser(user);
			}
		}
		return address;
	}

}
