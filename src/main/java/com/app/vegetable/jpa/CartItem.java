package com.app.vegetable.jpa;

import java.io.Serializable;
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
@Table(name = "CART_ITEM")
public class CartItem implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "ITEM_COUNT")
	private int itemCount;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ITEM_ID")
	private ProductItem productItem;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ITEM_DETAILS_ID")
	private ProductItemDetails productItemDetails;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ITEM_IMAGE_ID")
	private ProductItemImage productItemImage;

	@OneToMany(mappedBy = "cartItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetailsList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public ProductItemDetails getProductItemDetails() {
		return productItemDetails;
	}

	public void setProductItemDetails(ProductItemDetails productItemDetails) {
		this.productItemDetails = productItemDetails;
	}

	public ProductItemImage getProductItemImage() {
		return productItemImage;
	}

	public void setProductItemImage(ProductItemImage productItemImage) {
		this.productItemImage = productItemImage;
	}

	public List<OrderDetails> getOrderDetailsList() {
		return orderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}

}
