package com.app.vegetable.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.vegetable.business.CartItemBusiness;
import com.app.vegetable.jpa.CartItem;
import com.app.vegetable.repository.CartItemRepository;

@Service
public class CartItemBusinessImpl implements CartItemBusiness{

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Override
	public CartItem saveCartItem(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	@Override
	public CartItem getCartItemById(int cartItemId) {
		return cartItemRepository.getOne(cartItemId);
	}

	@Override
	public List<CartItem> getAllCartItem() {
		return cartItemRepository.findAll();
	}

	@Override
	public void deleteCartItemById(int cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}

	@Override
	public List<CartItem> getCartItemByUserId(int userId) {
		return cartItemRepository.getCartItemByUserId(userId);
	}

	@Override
	public int addItemCountIntoCart(int cartItemId, int itemCount) {
		//return cartItemRepository.updateById(cartItemId, itemCount);
		return 0;
	}

}
