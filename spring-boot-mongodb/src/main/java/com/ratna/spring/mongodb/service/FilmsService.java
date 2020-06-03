package com.ratna.spring.mongodb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratna.spring.mongodb.exceptions.NoActorsDataException;
import com.ratna.spring.mongodb.exceptions.NoFilmsDataException;
import com.ratna.spring.mongodb.model.Actors;
import com.ratna.spring.mongodb.model.Films;
import com.ratna.spring.mongodb.repository.FilmsRepository;

@Service
public class FilmsService implements FilmsServiceInterface {

	@Autowired
	FilmsRepository filmsRepository;

	public List<Films> getAllFilms() throws NoFilmsDataException {
		return filmsRepository.findAll();
	}

	public List<Films> getFilmsByActor(String name) throws NoFilmsDataException {
		List<Films> findByActors = filmsRepository.findByActors(name);
		findByActors.forEach(obj -> {
			obj.getActors().removeIf(actor -> !actor.getFirstName().equalsIgnoreCase(name));
		});
		return findByActors;
	}

	public List<Films> getFilmsByCategory(String category) throws NoFilmsDataException {
		return filmsRepository.findByCategory(category);
	}

	public List<Films> getFilmsByRating(String rating) throws NoFilmsDataException {
		return filmsRepository.findByRating(rating);
	}

	public List<Actors> getAllActors() throws NoActorsDataException {
		return filmsRepository.findAll().stream().flatMap(obj -> obj.getActors().stream()).collect(Collectors.toList());
	}
}
