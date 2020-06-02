package com.ratna.spring.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Actors {

	private Integer actorId;
	@Field(name = "First name")
	private String firstName;

	@Field(name = "Last name")
	private String lastName;

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
