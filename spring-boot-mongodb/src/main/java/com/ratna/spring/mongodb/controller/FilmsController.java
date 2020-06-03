package com.ratna.spring.mongodb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ratna.spring.mongodb.exceptions.NoActorsDataException;
import com.ratna.spring.mongodb.exceptions.NoFilmsDataException;
import com.ratna.spring.mongodb.model.Actors;
import com.ratna.spring.mongodb.model.Films;
import com.ratna.spring.mongodb.service.FilmsService;

@RestController
public class FilmsController {

	@Autowired
	FilmsService filmsService;

	@GetMapping("/getAllFilms")
	public List<Films> getAllFilms() {
		try {
			return filmsService.getAllFilms();
		} catch (NoFilmsDataException e) {
			throw new NoFilmsDataException("No Films available");
		}
	}

	@GetMapping("/getAllFilms/actor/{actor}")
	public List<Films> getFilmsOfActor(@PathVariable String actor) {
		try {
			return filmsService.getFilmsByActor(actor);
		} catch (NoFilmsDataException e) {
			throw new NoFilmsDataException("No Films available with given Actor:: " + actor);
		}
	}

	@GetMapping("/getAllFilms/category/{category}")
	public List<Films> getFilmsByCategory(@PathVariable String category) {
		try {
			return filmsService.getFilmsByCategory(category);
		} catch (NoFilmsDataException e) {
			throw new NoFilmsDataException("No Films available with selected Category:: " + category);
		}
	}

	@GetMapping("/getAllFilms/rating/{rating}")
	public List<Films> getFilmsByRating(@PathVariable String rating) throws NoFilmsDataException {
		try {
			return filmsService.getFilmsByRating(rating);
		} catch (NoFilmsDataException e) {
			throw new NoFilmsDataException("No Films available with selected Rating:: " + rating);
		}
	}

	@GetMapping("/getAllActors")
	public List<Actors> getAllActors() {
		try {
			return filmsService.getAllActors();
		} catch (NoActorsDataException e) {
			throw new NoActorsDataException("No Actors Available");
		}
	}

}
