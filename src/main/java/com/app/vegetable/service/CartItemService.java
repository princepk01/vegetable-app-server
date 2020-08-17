package com.app.vegetable.service;

import java.util.List;

import com.app.vegetable.jpa.CartItem;

public interface CartItemService {

	public CartItem saveCartItem(CartItem cartItem);

	public CartItem getCartItemById(int cartItemId);

	public List<CartItem> getAllCartItem();

	public void deleteCartItemById(int cartItemId);

	public List<CartItem> getCartItemByUserId(int userId);

	public int addItemCountIntoCart(int cartItemId, int itemCount);
}
