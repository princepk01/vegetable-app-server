package com.app.vegetable.business;

import java.util.List;

import com.app.vegetable.exception.CommonException;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.LoginModel;

public interface UserBusiness {

	public User saveUser(User user);

	public User getUserByUserId(int userId);

	public List<User> getAllUser();

	public void deleteUserByUserId(int userId);

	public User loginUser(LoginModel loginModel) throws CommonException;
}
