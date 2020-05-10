package com.app.vegetable.jpa;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_ITEM_DETAILS")
public class ProductItemDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "NUTRIENT_VALUE_AND_LIFE")
	private String nutrientValueAndLife;
	@Column(name = "SHELF_LIFE")
	private String shelfLife;
	@Column(name = "STORAGE_TIPS")
	private String stroageTips;
	@Column(name = "UNIT")
	private String unit;
	@Column(name = "SELLER")
	private String seller;
	@Column(name = "DESCRIPTION", columnDefinition = "LONGTEXT")
	private String description;
	@Column(name = "DISCLAIMER",  columnDefinition = "LONGTEXT")
	private String disclaimer;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "MODIFIED_DATE")
	private Timestamp modifiedDate;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ITEM_ID")
	private ProductItem productItem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNutrientValueAndLife() {
		return nutrientValueAndLife;
	}

	public void setNutrientValueAndLife(String nutrientValueAndLife) {
		this.nutrientValueAndLife = nutrientValueAndLife;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getStroageTips() {
		return stroageTips;
	}

	public void setStroageTips(String stroageTips) {
		this.stroageTips = stroageTips;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

}
