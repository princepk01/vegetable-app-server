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
import com.app.vegetable.jpa.ProductItem;
import com.app.vegetable.model.ProductItemModel;
import com.app.vegetable.service.ProductItemService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "/product-item")
public class ProductItemController extends BaseController{

	@Autowired
	private ProductItemService productItemService;
	
	@PostMapping(value = "/save-product-item")
	public ResponseEntity<?> saveProductItem(@RequestBody ProductItemModel productItemModel ) throws IOException {
		ResponseMessage responseMessage = new ResponseMessage();
		if (productItemModel != null) {
			ProductItem productItem = ModelToJpaConvertor.getJpaObject(productItemModel);
			productItemService.saveProductItem(productItem);
			if (productItemModel.getId() == 0) {
				responseMessage.setMessage("Product item saved successfully");
			} else {
				responseMessage.setMessage("Product item updated successfully");
			}
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	
	@GetMapping(value = "/get-product-item-by-id/{productItemId}")
	public ResponseEntity<?> getProductbyId(@PathVariable("productItemId") int productItemId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (productItemId != 0) {
			 ProductItem productItem = productItemService.getProductItemById(productItemId);
			 ProductItemModel productItemModel = JpaToModelConvertor.getModelObject(productItem);
			if (productItemModel != null) {
				responseMessage.setData(productItemModel);
			}
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-all-product-items")
	public ResponseEntity<?> getAllProductItem() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<ProductItem> productItemList = productItemService.getAllProductItem();
		if (productItemList != null && !productItemList.isEmpty()) {
			List<ProductItemModel> productItemModelList = JpaToModelConvertor.getProductItemModelListObject(productItemList);
			responseMessage.setData(productItemModelList);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/delete-product-item-by-id/{productItemId}")
	public ResponseEntity<?> deleteProductById(@PathVariable("productItemId") int productItemId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (productItemId != 0) {
			productItemService.deleteProductItemById(productItemId);
			responseMessage.setStatus(true);
			responseMessage.setMessage("Product item deleted successfully");
		}
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-product-items-by-product-id/{productId}")
	public ResponseEntity<?> getProductItemsByProductId(@PathVariable("productId") int productId) {
		ResponseMessage responseMessage = new ResponseMessage();
		List<ProductItem> productItemList = productItemService.getProductItemsByProductId(productId);
		if (productItemList != null && !productItemList.isEmpty()) {
			List<ProductItemModel> productItemModelList = JpaToModelConvertor.getProductItemModelListObject(productItemList);
			responseMessage.setData(productItemModelList);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}
	
	@GetMapping(value = "/get-product-items-by-product-name/{productName}")
	public ResponseEntity<?> getProductItemByProductName(@PathVariable("productName") String productName) {
		ResponseMessage responseMessage = new ResponseMessage();
		List<ProductItem> productItemList = productItemService.getProductItemByProductName(productName);
		if (productItemList != null && !productItemList.isEmpty()) {
			List<ProductItemModel> productItemModelList = JpaToModelConvertor.getProductItemModelListObject(productItemList);
			responseMessage.setData(productItemModelList);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
		
	}
}
