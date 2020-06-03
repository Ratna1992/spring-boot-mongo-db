package com.ratna.spring.mongodb.service;

import java.util.List;

import com.ratna.spring.mongodb.model.Actors;
import com.ratna.spring.mongodb.model.Films;

public interface FilmsServiceInterface {

	public List<Films> getAllFilms();

	public List<Films> getFilmsByActor(String name);

	public List<Films> getFilmsByCategory(String category);

	public List<Films> getFilmsByRating(String rating);

	public List<Actors> getAllActors();

}
