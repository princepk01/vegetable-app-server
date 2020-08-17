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
	@Column(name = "ITEM_MRP")
	private int itemMrp;
	@Column(name = "DISCOUNT_PRICE")
	private int discountPrice;
	@Column(name = "REMAINING_QUANTITY")
	private int remainingQuantity;
	@Column(name = "TOTAL_SELL_QUANTITY")
	private int totalSellQuantity;
	@Column(name = "QUANTITY_SELL_AMOUNT")
	private int quantitySellAmount;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "MODIFIED_DATE")
	private Timestamp modifiedDate;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductItemImage> productItemImageList;

	@OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductItemDetails> productItemDetailsList;

	@OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItem> cartItemList; 
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

	public int getItemMrp() {
		return itemMrp;
	}

	public void setItemMrp(int itemMrp) {
		this.itemMrp = itemMrp;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public int getTotalSellQuantity() {
		return totalSellQuantity;
	}

	public void setTotalSellQuantity(int totalSellQuantity) {
		this.totalSellQuantity = totalSellQuantity;
	}

	public int getQuantitySellAmount() {
		return quantitySellAmount;
	}

	public void setQuantitySellAmount(int quantitySellAmount) {
		this.quantitySellAmount = quantitySellAmount;
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

	public List<ProductItemDetails> getProductItemDetailsList() {
		return productItemDetailsList;
	}

	public void setProductItemDetailsList(List<ProductItemDetails> productItemDetailsList) {
		this.productItemDetailsList = productItemDetailsList;
	}

	public void addProductItemImage(ProductItemImage productItemImage) {
		if (productItemImageList == null || productItemImageList.isEmpty()) {
			productItemImageList = new ArrayList<ProductItemImage>();
		}
		productItemImageList.add(productItemImage);
		productItemImage.setProductItem(this);
	}

	public void addProductItemDetails(ProductItemDetails productItemDetails) {
		if (productItemDetailsList == null || productItemDetailsList.isEmpty()) {
			productItemDetailsList = new ArrayList<ProductItemDetails>();
		}
		productItemDetailsList.add(productItemDetails);
		productItemDetails.setProductItem(this);
	}
}
