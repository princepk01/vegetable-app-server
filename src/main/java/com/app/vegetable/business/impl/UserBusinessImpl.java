package com.app.vegetable.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.UserBusiness;
import com.app.vegetable.exception.CommonException;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.LoginModel;
import com.app.vegetable.repository.UserRepository;

@Service
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserByUserId(int userId) {
		return userRepository.getOne(userId);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserByUserId(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User loginUser(LoginModel loginModel) throws CommonException {
		User user = null;
		if(loginModel != null) {
			String emailOrMobileNumber = loginModel.getEmailOrMobileNumber();
			String password = loginModel.getPassword();
			user = userRepository.getUserByMobileNumberAndPassword(emailOrMobileNumber, password);
			if(user == null) {
				user = userRepository.getuserByEmailAddressAndPassword(loginModel.getEmailOrMobileNumber(), password);
			}
			if(user != null && !password.equals(user.getPassword())) {
				throw new CommonException("Mobile number or password doesn't exit.");
			}
		}
		if(user == null) {
			throw new CommonException("Mobile number or email address doesn't exit.");
		}
		return user;
	}

}
