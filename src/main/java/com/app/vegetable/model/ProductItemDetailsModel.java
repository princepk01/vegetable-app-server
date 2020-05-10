package com.app.vegetable.model;

public class ProductItemDetailsModel {
	private int id;
	private String nutrientValueAndLife;
	private String shelfLife;
	private String stroageTips;
	private String unit;
	private String seller;
	private String description;
	private String disclaimer;

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

}
