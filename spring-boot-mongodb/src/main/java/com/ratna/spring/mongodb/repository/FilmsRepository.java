package com.ratna.spring.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ratna.spring.mongodb.model.Films;

@Repository
public interface FilmsRepository extends MongoRepository<Films, Integer> {
	@Query("{'actors.firstName':?0}")
	List<Films> findByActors(String name);
	List<Films> findByCategory(String category);
	List<Films> findByRating(String rating);

}
