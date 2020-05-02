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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_ITEM")
public class ProductItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "TOTAL_QUANTITY")
	private int totalQuantity;
	@Column(name = "TOTAL_PRICE")
	private int totalPrice;
	@Column(name = "SELL_PRICE")
	private int sellPrice;
	@Column(name = "ITEM_DESCRIPTION")
	private int itemDescription;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "MODIFIED_DATE")
	private Timestamp modifiedDate;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductItemImage> productItemImageList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(int itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductItemImage> getProductItemImageList() {
		return productItemImageList;
	}

	public void setProductItemImageList(List<ProductItemImage> productItemImageList) {
		this.productItemImageList = productItemImageList;
	}

	public void addProductItemImage(ProductItemImage productItemImage) {
		if (productItemImageList == null || productItemImageList.isEmpty()) {
			productItemImageList = new ArrayList<ProductItemImage>();
		}
		productItemImageList.add(productItemImage);
		productItemImage.setProductItem(this);
	}
}