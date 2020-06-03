package com.ratna.spring.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Inventory {

	private Integer filmId;
	private Integer inventoryId;
	@Field(name = "Film Title")
	private String title;
	public Integer getFilmId() {
		return filmId;
	}
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Inventory [filmId=" + filmId + ", inventoryId=" + inventoryId + ", title=" + title + "]";
	}
	
	

}
