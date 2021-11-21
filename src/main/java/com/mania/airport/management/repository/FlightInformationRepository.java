package com.mania.airport.management.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mania.airport.management.domain.FlightInformation;

public interface FlightInformationRepository extends MongoRepository<FlightInformation, String> {

	List<FlightInformation> findByDepartureCityAndDestinationCity(String departure, String destination);

	/*
	 * method name doesn't matter here as we are providing custom Mongo Query.
	 */
	@Query("{'aircraft.nbSeats' : {$gte: ?0}}")
	List<FlightInformation> findByMinAircraftNbSeats(int minNbSeats);
	// To make sure this works, remove the custom converter for aircraft that you
	// made earlier. That uses a string.
}
