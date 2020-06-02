package com.ratna.spring.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "films")
public class Films {

	@Id
	@Field(name = "_id")
	private Integer id;
	@Field(name = "Actors")
	private List<Actors> actors;
	@Field(name = "Category")
	private String category;
	@Field(name = "Description")
	private String description;
	@Field(name = "Length")
	private String length;
	@Field(name = "Rating")
	private String rating;
	@Field(name = "Rental Duration")
	private String rentalDuration;
	@Field(name = "Replacement Cost")
	private String replacementCost;
	@Field(name = "Special Features")
	private String splFeatures;
	@Field(name = "Title")
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Actors> getActors() {
		return actors;
	}
	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(String rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public String getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(String replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getSplFeatures() {
		return splFeatures;
	}
	public void setSplFeatures(String splFeatures) {
		this.splFeatures = splFeatures;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Films [id=" + id + ", actors=" + actors + ", category=" + category + ", description=" + description
				+ ", length=" + length + ", rating=" + rating + ", rentalDuration=" + rentalDuration
				+ ", replacementCost=" + replacementCost + ", splFeatures=" + splFeatures + ", title=" + title + "]";
	}
	

}
