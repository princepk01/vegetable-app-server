package com.app.vegetable.converter;

import java.io.IOException;
import java.util.List;

import com.app.vegetable.jpa.Address;
import com.app.vegetable.jpa.CartItem;
import com.app.vegetable.jpa.OrderDetails;
import com.app.vegetable.jpa.PlacedOrder;
import com.app.vegetable.jpa.Product;
import com.app.vegetable.jpa.ProductItem;
import com.app.vegetable.jpa.ProductItemDetails;
import com.app.vegetable.jpa.ProductItemImage;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.AddressModel;
import com.app.vegetable.model.CartItemModel;
import com.app.vegetable.model.OrderDetailsModel;
import com.app.vegetable.model.PlacedOrderModel;
import com.app.vegetable.model.ProductItemDetailsModel;
import com.app.vegetable.model.ProductItemImageModel;
import com.app.vegetable.model.ProductItemModel;
import com.app.vegetable.model.ProductModel;
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
			if (userId != 0) {
				User user = new User();
				user.setId(userId);
				address.setUser(user);
			}
		}
		return address;
	}

	public static Product getJpaObject(ProductModel productModel) {
		Product product = null;
		if (productModel != null) {
			product = new Product();

			product.setId(productModel.getId());
			product.setProductName(productModel.getProductName());
//			product.setProductImage(productModel.getProductImage());
//			product.setProductImageFileName(productModel.getProductImageFileName());
			product.setProductImageUrl(productModel.getProductImageUrl());
		}
		return product;
	}

	public static ProductItem getJpaObject(ProductItemModel productItemModel) throws IOException {
		ProductItem productItem = null;
		if (productItemModel != null) {
			productItem = new ProductItem();

			productItem.setId(productItemModel.getId());
			productItem.setItemName(productItemModel.getItemName());
			productItem.setTotalQuantity(productItemModel.getTotalQuantity());
			productItem.setTotalPrice(productItemModel.getTotalPrice());
			productItem.setItemMrp(productItemModel.getItemMrp());
			productItem.setDiscountPrice(productItemModel.getDiscountPrice());
			productItem.setRemainingQuantity(productItemModel.getRemainingQuantity());
			productItem.setTotalSellQuantity(productItemModel.getTotalSellQuantity());
			ProductItemImageModel productItemImageModel = productItemModel.getProductItemImageModel();
			if (productItemImageModel != null) {
				ProductItemImage productItemImage = new ProductItemImage();
				productItemImage.setId(productItemImageModel.getId());
				productItemImage.setItemInageFileUrl(productItemImageModel.getItemInageFileUrl());
				productItem.addProductItemImage(productItemImage);
			}
			if (productItemModel.getProductId() != 0) {
				Product product = new Product();
				product.setId(productItemModel.getProductId());
				productItem.setProduct(product);
			}
			/*
			 * List<ProductItemDetailsModel> productItemDetailsModelList = productItemModel
			 * .getProductItemDetailsModelList();
			 */
			ProductItemDetailsModel productItemDetailsModel = productItemModel.getProductItemDetailsModel();
			if (productItemDetailsModel != null) {
				productItem.addProductItemDetails(getproductItemDetailsJpaObject(productItemDetailsModel));
			}
		}
		return productItem;
	}

	public static ProductItemDetails getproductItemDetailsJpaObject(ProductItemDetailsModel productItemDetailsModel) {
		ProductItemDetails productItemDetails = null;
		if (productItemDetailsModel != null) {
			productItemDetails = new ProductItemDetails();
			productItemDetails.setId(productItemDetailsModel.getId());
			productItemDetails.setNutrientValueAndLife(productItemDetailsModel.getNutrientValueAndLife());
			productItemDetails.setShelfLife(productItemDetailsModel.getShelfLife());
			productItemDetails.setStroageTips(productItemDetailsModel.getStroageTips());
			productItemDetails.setUnit(productItemDetailsModel.getUnit());
			productItemDetails.setSeller(productItemDetailsModel.getSeller());
			productItemDetails.setDescription(productItemDetailsModel.getDescription());
			productItemDetails.setDisclaimer(productItemDetailsModel.getDisclaimer());
		}
		return productItemDetails;
	}

	public static CartItem getJpaObject(CartItemModel cartItemModel) throws IOException {
		CartItem cartItem = null;
		if (cartItemModel != null) {
			cartItem = new CartItem();

			cartItem.setId(cartItemModel.getId());
			cartItem.setItemCount(cartItemModel.getItemCount());

			ProductItemDetailsModel productItemDetailsModel = cartItemModel.getProductItemDetailsModel();
			if (productItemDetailsModel != null) {
				ProductItemDetails productItemDetails = new ProductItemDetails();
				productItemDetails.setId(productItemDetailsModel.getId());
				cartItem.setProductItemDetails(productItemDetails);
			}

			ProductItemModel productItemModel = cartItemModel.getProductItemModel();
			if (productItemModel != null) {
				cartItem.setProductItem(getJpaObject(productItemModel));
			}

			ProductItemImageModel productItemImageModel = cartItemModel.getProductItemImageModel();
			if (productItemImageModel != null) {
				ProductItemImage productItemImage = new ProductItemImage();
				productItemImage.setId(productItemImageModel.getId());
				productItemImage.setItemInageFileUrl(productItemImageModel.getItemInageFileUrl());
				cartItem.setProductItemImage(productItemImage);
			}

			int userId = cartItemModel.getUserId();
			if (userId != 0) {
				User user = new User();
				user.setId(userId);
				cartItem.setUser(user);
			}
		}
		return cartItem;
	}

	public static PlacedOrder getJpaObject(PlacedOrderModel placedOrderModel) throws IOException {
		PlacedOrder placedOrder = null;
		if (placedOrderModel != null) {

			placedOrder = new PlacedOrder();

			placedOrder.setId(placedOrderModel.getId());
			placedOrder.setTotalAmount(placedOrderModel.getTotalAmount());
			placedOrder.setTotalItem(placedOrderModel.getTotalItem());
			placedOrder.setDeliveredStatus("PENDING");

			AddressModel addressModel = placedOrderModel.getAddressModel();
			if (addressModel != null) {
				Address address = new Address();
				address.setId(addressModel.getId());
				placedOrder.setAddress(address);
			}

			UserModel userModel = placedOrderModel.getUserModel();
			if (userModel != null) {
				User user = new User();
				user.setId(userModel.getId());
				placedOrder.setUser(user);
			}

			List<OrderDetailsModel> orderDetailsModelList = placedOrderModel.getOrderDetailsModelList();

			if (orderDetailsModelList != null && !orderDetailsModelList.isEmpty()) {
				for (OrderDetailsModel orderDetailsModel : orderDetailsModelList) {
					placedOrder.addOrderDetails(getJpaobject(orderDetailsModel));
				}
			}

		}
		return placedOrder;
	}

	private static OrderDetails getJpaobject(OrderDetailsModel orderDetailsModel) throws IOException {
		OrderDetails orderDetails = null;
		
		if (orderDetailsModel != null) {

			orderDetails = new OrderDetails();
			orderDetails.setId(orderDetailsModel.getId());
			orderDetails.setOrderPrice(orderDetailsModel.getOrderPrice());
			orderDetails.setItemImageUrl(orderDetailsModel.getItemImageUrl());
			orderDetails.setItemName(orderDetailsModel.getItemName());
			orderDetails.setUnit(orderDetailsModel.getUnit());
			
			CartItemModel cartItemModel = orderDetailsModel.getCartItemModel();
			if(cartItemModel != null) {
				CartItem cartItem = new CartItem();
				cartItem.setId(cartItemModel.getId());
				orderDetails.setCartItem(cartItem);
			}
		}
		return orderDetails;
	}

}
