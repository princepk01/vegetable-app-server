package com.app.vegetable.converter;

import java.util.ArrayList;
import java.util.List;

import com.app.vegetable.jpa.Address;
import com.app.vegetable.jpa.Product;
import com.app.vegetable.jpa.ProductItem;
import com.app.vegetable.jpa.ProductItemDetails;
import com.app.vegetable.jpa.ProductItemImage;
import com.app.vegetable.jpa.User;
import com.app.vegetable.model.AddressModel;
import com.app.vegetable.model.ProductItemDetailsModel;
import com.app.vegetable.model.ProductItemImageModel;
import com.app.vegetable.model.ProductItemModel;
import com.app.vegetable.model.ProductModel;
import com.app.vegetable.model.UserModel;

public class JpaToModelConvertor {

	public static UserModel getModelObject(User user) {
		UserModel userModel = null;
		if (user != null) {
			userModel = new UserModel();

			userModel.setId(user.getId());
			userModel.setName(user.getName());
			userModel.setMobileNumber(user.getMobileNumber());
			userModel.setPassword(user.getPassword());
			userModel.setEmailAddress(user.getEmailAddress());
			userModel.setGender(user.getGender());
			userModel.setCreatedDate(user.getCreatedDate());
			userModel.setModifiedDate(user.getModifiedDate());
			userModel.setUserRole(user.getUserRole());
		}
		return userModel;
	}

	public static List<UserModel> getModelListObject(List<User> userList) {
		List<UserModel> userModelList = null;
		if (userList != null && !userList.isEmpty()) {
			userModelList = new ArrayList<UserModel>();
			for (User user : userList) {
				userModelList.add(getModelObject(user));
			}
		}
		return userModelList;
	}

	public static AddressModel getModelObject(Address address) {
		AddressModel addressModel = null;
		if (address != null) {
			addressModel = new AddressModel();

			addressModel.setId(address.getId());
			addressModel.setName(address.getName());
			addressModel.setMobileNumber(address.getMobileNumber());
			addressModel.setPinCode(address.getPinCode());
			addressModel.setAddress(address.getAddress());
			addressModel.setCity(address.getCity());
			addressModel.setState(address.getState());
			addressModel.setCreatedDate(address.getCreatedDate());
			addressModel.setModifiedDate(address.getModifiedDate());
		}
		return addressModel;
	}

	public static List<AddressModel> getModelListAddressObject(List<Address> addressList) {
		List<AddressModel> addressModelList = null;
		if (addressList != null && !addressList.isEmpty()) {
			addressModelList = new ArrayList<AddressModel>();
			for (Address address : addressList) {
				addressModelList.add(getModelObject(address));
			}
		}

		return addressModelList;
	}

	public static ProductModel getModelObject(Product product) {
		ProductModel productModel = null;
		if (product != null) {
			productModel = new ProductModel();

			productModel.setId(product.getId());
			productModel.setProductName(product.getProductName());
//			productModel.setProductImage(product.getProductImage());
//			productModel.setProductImageFileName(product.getProductImageFileName());
			productModel.setProductImageUrl(product.getProductImageUrl());
		}
		return productModel;
	}

	public static List<ProductModel> getProductModelListObject(List<Product> productList) {
		List<ProductModel> productModelList = null;
		if (productList != null && !productList.isEmpty()) {
			productModelList = new ArrayList<ProductModel>();
			for (Product product : productList) {
				productModelList.add(getModelObject(product));
			}
		}
		return productModelList;
	}

	public static ProductItemModel getModelObject(ProductItem productItem) {
		ProductItemModel productItemModel = null;
		if (productItem != null) {

			productItemModel = new ProductItemModel();

			productItemModel.setId(productItem.getId());
			productItemModel.setItemName(productItem.getItemName());
			productItemModel.setTotalQuantity(productItem.getTotalQuantity());
			productItemModel.setTotalPrice(productItem.getTotalPrice());
			productItemModel.setItemMrp(productItem.getItemMrp());
			productItemModel.setDiscountPrice(productItem.getDiscountPrice());
			productItemModel.setRemainingQuantity(productItem.getRemainingQuantity());
			productItemModel.setTotalSellQuantity(productItem.getTotalSellQuantity());
			if(productItem.getProduct() != null) {
				productItemModel.setProductId(productItem.getProduct().getId());
			}
			List<ProductItemImage> productItemImageList = productItem.getProductItemImageList();
			if (productItemImageList != null && !productItemImageList.isEmpty()) {
				ProductItemImageModel productItemImageModel = new ProductItemImageModel();
				for (ProductItemImage productItemImage : productItemImageList) {
					productItemImageModel.setId(productItemImage.getId());
					productItemImageModel.setItemInageFileUrl(productItemImage.getItemInageFileUrl());
				}
				productItemModel.setProductItemImageModel(productItemImageModel);
			}

			List<ProductItemDetails> productItemDetailsList = productItem.getProductItemDetailsList();
			if (productItemDetailsList != null && !productItemDetailsList.isEmpty()) {

				for (ProductItemDetails productItemDetails : productItemDetailsList) {
					productItemModel.setProductItemDetailsModel(getProductItemDetailsModelObject(productItemDetails));

				}
			}
		}
		return productItemModel;
	}

	public static ProductItemDetailsModel getProductItemDetailsModelObject(ProductItemDetails productItemDetails) {
		ProductItemDetailsModel productItemDetailsModel = null;
		if (productItemDetails != null) {
			productItemDetailsModel = new ProductItemDetailsModel();
			productItemDetailsModel.setId(productItemDetails.getId());
			productItemDetailsModel.setNutrientValueAndLife(productItemDetails.getNutrientValueAndLife());
			productItemDetailsModel.setShelfLife(productItemDetails.getShelfLife());
			productItemDetailsModel.setStroageTips(productItemDetails.getStroageTips());
			productItemDetailsModel.setUnit(productItemDetails.getUnit());
			productItemDetailsModel.setSeller(productItemDetails.getSeller());
			productItemDetailsModel.setDescription(productItemDetails.getDescription());
			productItemDetailsModel.setDisclaimer(productItemDetails.getDisclaimer());
		}
		return productItemDetailsModel;
	}

	public static List<ProductItemModel> getProductItemModelListObject(List<ProductItem> productItemList) {
		List<ProductItemModel> productItemModelList = null;
		if (productItemList != null && !productItemList.isEmpty()) {
			productItemModelList = new ArrayList<ProductItemModel>();
			for (ProductItem productItem : productItemList) {
				productItemModelList.add(getModelObject(productItem));
			}
		}
		return productItemModelList;
	}

}
