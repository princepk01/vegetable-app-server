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
import com.app.vegetable.jpa.Product;
import com.app.vegetable.model.ProductModel;
import com.app.vegetable.service.ProductService;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/save-product")
	public ResponseEntity<?> saveProduct(@RequestBody ProductModel productModel ){
		ResponseMessage responseMessage = new ResponseMessage();
		if (productModel != null) {
			Product product = ModelToJpaConvertor.getJpaObject(productModel);
			productService.saveProduct(product);
			if (productModel.getId() == 0) {
				responseMessage.setMessage("Product saved successfully");
			} else {
				responseMessage.setMessage("Product updated successfully");
			}
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-product-by-id/{productId}")
	public ResponseEntity<?> getProductbyId(@PathVariable("productId") int productId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (productId != 0) {
			Product product = productService.getProductById(productId);
			ProductModel productModel = JpaToModelConvertor.getModelObject(product);
			if (productModel != null) {
				responseMessage.setData(productModel);
			}
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-all-products")
	public ResponseEntity<?> getAllProduct() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<Product> productList = productService.getAllProduct();
		if (productList != null && !productList.isEmpty()) {
			List<ProductModel> productModelList = JpaToModelConvertor.getProductModelListObject(productList);
			responseMessage.setData(productModelList);
		}
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-product-by-id/{productId}")
	public ResponseEntity<?> deleteProductById(@PathVariable("productId") int productId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (productId != 0) {
			productService.deleteProductById(productId);
			responseMessage.setStatus(true);
			responseMessage.setMessage("Product deleted successfully");
		}
		return sendResponse(responseMessage);
	}
}
