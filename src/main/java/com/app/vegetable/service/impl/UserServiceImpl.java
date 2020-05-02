package com.app.vegetable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.UserBusiness;
import com.app.vegetable.exception.CommonException;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.LoginModel;
import com.app.vegetable.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBusiness userBusiness;

	@Override
	public User saveUser(User user) {
		return userBusiness.saveUser(user);
	}

	@Override
	public User getUserByUserId(int userId) {
		return userBusiness.getUserByUserId(userId);
	}

	@Override
	public List<User> getAllUser() {
		return userBusiness.getAllUser();
	}

	@Override
	public void deleteUserByUserId(int userId) {
		userBusiness.deleteUserByUserId(userId);

	}

	@Override
	public User loginUser(LoginModel loginModel) throws CommonException {
		return userBusiness.loginUser(loginModel);
	}

}
