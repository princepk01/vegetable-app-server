package com.app.vegetable.jpa;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_IMAGE_URL", columnDefinition = "LONGTEXT")
	private String productImageUrl;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "MODIFIED_DATE")
	private Timestamp modifiedDate;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductItem> productItemList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

//	public byte[] getProductImage() {
//		return productImage;
//	}
//
//	public void setProductImage(byte[] productImage) {
//		this.productImage = productImage;
//	}
//
//	public String getProductImageFileName() {
//		return productImageFileName;
//	}
//
//	public void setProductImageFileName(String productImageFileName) {
//		this.productImageFileName = productImageFileName;
//	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<ProductItem> getProductItemList() {
		return productItemList;
	}

	public void setProductItemList(List<ProductItem> productItemList) {
		this.productItemList = productItemList;
	}

	public void addProductItem(ProductItem productItem) {
		if (productItemList == null || productItemList.isEmpty()) {
			productItemList = new ArrayList<ProductItem>();
		}
		productItemList.add(productItem);
		productItem.setProduct(this);
	}
}
