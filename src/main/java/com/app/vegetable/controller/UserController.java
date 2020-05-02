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
import com.app.vegetable.exception.CommonException;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.LoginModel;
import com.app.vegetable.model.UserModel;
import com.app.vegetable.service.UserService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/save-user")
	public ResponseEntity<?> saveUser(@RequestBody UserModel userModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		User user = ModelToJpaConvertor.getJpaObject(userModel);
		userService.saveUser(user);
		if (userModel.getId() == 0) {
			responseMessage.setMessage("User saved successfully.");
		} else {
			responseMessage.setMessage("User updated successfully.");
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-user-by-id/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") int userId) {
		ResponseMessage responseMessage = new ResponseMessage();
		User user = userService.getUserByUserId(userId);
		UserModel userModel = JpaToModelConvertor.getModelObject(user);
		if (userModel != null) {
			responseMessage.setData(user);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-all-user")
	public ResponseEntity<?> getAllUser() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<User> userList = userService.getAllUser();
		if (userList != null && !userList.isEmpty()) {
			List<UserModel> userModelList = JpaToModelConvertor.getModelListObject(userList);
			responseMessage.setData(userModelList);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-user-by-id/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable("userId") int userId) {
		ResponseMessage responseMessage = new ResponseMessage();
		userService.deleteUserByUserId(userId);
		responseMessage.setStatus(true);
		responseMessage.setMessage("User delted successfully");
		return sendResponse(responseMessage);
	}
	@PostMapping(value = "/login-user")
	public ResponseEntity<?> loginUser(@RequestBody LoginModel loginModel) throws CommonException {
		ResponseMessage responseMessage = new ResponseMessage();
		User user = userService.loginUser(loginModel);
			if(user != null) {
				UserModel userModel = JpaToModelConvertor.getModelObject(user);
				responseMessage.setData(userModel);
				responseMessage.setStatus(true);
			}
		return sendResponse(responseMessage);
	}
}
