package com.app.vegetable.jpa;

import java.sql.Timestamp;
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
@Table(name = "PRODUCT_ITEM_IMAGE")
public class ProductItemImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
//	@Column(name = "ITEM_IMAGE")
//	@Lob
//	private byte[] itemImage;
//	@Column(name = "ITEM_IMAGE_FILE_NAME")
//	private String itemImageFileName;
	@Column(name = "ITEM_IMAGE_FILE_URL", columnDefinition = "LONGTEXT")
	private String itemInageFileUrl;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "MODIFIED_DATE")
	private Timestamp modifiedDate;
	
	@ManyToOne
	@JoinColumn(name = "product_item_id")
	private ProductItem productItem;

	@OneToMany(mappedBy = "productItemImage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CartItem> cartItemList;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public byte[] getItemImage() {
//		return itemImage;
//	}
//
//	public void setItemImage(byte[] itemImage) {
//		this.itemImage = itemImage;
//	}
//
//	public String getItemImageFileName() {
//		return itemImageFileName;
//	}
//
//	public void setItemImageFileName(String itemImageFileName) {
//		this.itemImageFileName = itemImageFileName;
//	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public String getItemInageFileUrl() {
		return itemInageFileUrl;
	}

	public void setItemInageFileUrl(String itemInageFileUrl) {
		this.itemInageFileUrl = itemInageFileUrl;
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

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

}
