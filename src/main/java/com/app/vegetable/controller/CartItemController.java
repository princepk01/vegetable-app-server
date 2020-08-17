package com.app.vegetable.controller;

import java.io.IOException;
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
import com.app.vegetable.jpa.CartItem;
import com.app.vegetable.model.CartItemModel;
import com.app.vegetable.service.CartItemService;

@RestController
@RequestMapping(value = "/cart-item")
@CrossOrigin(value = "http://localhost:4200")
public class CartItemController extends BaseController {

	@Autowired
	private CartItemService cartItemService;

	@PostMapping(value = "/save-cart-item")
	public ResponseEntity<?> saveCartItem(@RequestBody CartItemModel cartItemModel) throws IOException {

		ResponseMessage responseMessage = new ResponseMessage();
		if (cartItemModel != null) {
			CartItem cartItem = ModelToJpaConvertor.getJpaObject(cartItemModel);
			cartItemService.saveCartItem(cartItem);
			if (cartItemModel.getId() == 0) {
				responseMessage.setMessage("Cart item seved successfully.");
			} else {
				responseMessage.setMessage("Cart item updated successfully.");
			}
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-cart-item-by-id/{cartItemId}")
	public ResponseEntity<?> getCartItemById(@PathVariable("cartItemId") int cartItemId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (cartItemId != 0) {
			CartItem cartItem = cartItemService.getCartItemById(cartItemId);
			if (cartItem != null) {
				CartItemModel cartItemModel = JpaToModelConvertor.getModelObject(cartItem);
				responseMessage.setData(cartItemModel);
			}
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-all-cart-item")
	public ResponseEntity<?> getAllCartItem() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<CartItem> cartItemList = cartItemService.getAllCartItem();
		if (cartItemList != null && !cartItemList.isEmpty()) {
			List<CartItemModel> cartItemModelList = JpaToModelConvertor.getCartItemModelListObject(cartItemList);
			responseMessage.setData(cartItemModelList);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-cart-item-by-id/{cartItemId}")
	public ResponseEntity<?> deleteCartItemById(@PathVariable("cartItemId") int cartItemId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (cartItemId != 0) {
			cartItemService.deleteCartItemById(cartItemId);
			responseMessage.setMessage("Cart item deleted successfully");
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-cart-item-by-user-id/{userId}")
	public ResponseEntity<?> getCartItemByUserId(@PathVariable("userId") int userId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (userId != 0) {
			List<CartItem> cartItem = cartItemService.getCartItemByUserId(userId);
			if (cartItem != null) {
				List<CartItemModel> cartItemModelList = JpaToModelConvertor.getCartItemModelListObject(cartItem);
				responseMessage.setData(cartItemModelList);
			}
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/add-cart-item-by-cart-item-id/{cartItemId}/{itemCount}")
	public ResponseEntity<?> addItemCountIntoCart(@PathVariable("cartItemId") int cartItemId, @PathVariable("itemCount") int itemCount) {
		ResponseMessage responseMessage = new ResponseMessage();
		cartItemService.addItemCountIntoCart(cartItemId, itemCount);
		responseMessage.setMessage("You have successfully changes the item count.");
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
}
