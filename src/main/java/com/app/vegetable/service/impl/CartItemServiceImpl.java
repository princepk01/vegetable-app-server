package com.app.vegetable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.CartItemBusiness;
import com.app.vegetable.jpa.CartItem;
import com.app.vegetable.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemBusiness cartItemBusiness;
	
	@Override
	public CartItem saveCartItem(CartItem cartItem) {
		return cartItemBusiness.saveCartItem(cartItem);
	}

	@Override
	public CartItem getCartItemById(int cartItemId) {
		return cartItemBusiness.getCartItemById(cartItemId);
	}

	@Override
	public List<CartItem> getAllCartItem() {
		return cartItemBusiness.getAllCartItem();
	}

	@Override
	public void deleteCartItemById(int cartItemId) {
		cartItemBusiness.deleteCartItemById(cartItemId);
	}

	@Override
	public List<CartItem> getCartItemByUserId(int userId) {
		return cartItemBusiness.getCartItemByUserId(userId);
	}

	@Override
	public int addItemCountIntoCart(int cartItemId, int itemCount) {
		return cartItemBusiness.addItemCountIntoCart(cartItemId, itemCount);
	}

}
