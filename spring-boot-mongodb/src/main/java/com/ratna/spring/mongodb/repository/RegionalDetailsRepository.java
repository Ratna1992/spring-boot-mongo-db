package com.ratna.spring.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratna.spring.mongodb.model.RegionDetails;

public interface RegionalDetailsRepository extends MongoRepository<RegionDetails, Integer> {
List<RegionDetails> findByArea(String area);
}
