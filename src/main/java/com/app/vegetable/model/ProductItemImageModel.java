package com.app.vegetable.model;

import java.sql.Timestamp;

public class ProductItemImageModel {

	private int id;
//	private byte[] itemImage;
//	private String itemImageFileName;
	private String itemInageFileUrl;
	private Timestamp createdDate;
	private Timestamp modifiedDate;

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

}
