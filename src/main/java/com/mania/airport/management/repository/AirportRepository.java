package com.mania.airport.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mania.airport.management.domain.Airport;

public interface AirportRepository extends MongoRepository<Airport, String>{

}
