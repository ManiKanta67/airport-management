package com.mania.airport.management;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mania.airport.management.domain.Aircraft;
import com.mania.airport.management.domain.Airport;
import com.mania.airport.management.domain.FlightInformation;
import com.mania.airport.management.domain.FlightType;
import com.mania.airport.management.repository.AirportRepository;
import com.mania.airport.management.repository.FlightInformationRepository;

/*
 * This is just a demo to test insertions, updation and deletions. Not product ready by any means.
 */
@Component
@Order(1)
public class DatabaseSeederRunner implements CommandLineRunner {

	private FlightInformationRepository  flightInformationRepository;
	private AirportRepository airportRepository;
	private MongoTemplate mongoTemplate;

	public DatabaseSeederRunner(FlightInformationRepository flightInformationRepository, AirportRepository airportRepository, MongoTemplate mongoTemplate) {
		this.flightInformationRepository = flightInformationRepository;
		this.airportRepository = airportRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		empty();
		seed();
	}

	private void seed() {
		// Airports
		Airport rome = new Airport("11", "Leonardo da Vinci", "Rome", 23478342);
		Airport paris = new Airport("12", "Charles de Gaulle", "Rome", 23478342);
		Airport copenhagen = new Airport("13", "Copenhange Airport", "Rome", 23478342);
		
		// Flight information
		FlightInformation flightOne = new FlightInformation();
		flightOne.setId("14");
		flightOne.setDelayed(false);
		flightOne.setDepartureCity(rome);
		flightOne.setDestinationCity(paris);
		flightOne.setDepartureDate(LocalDate.of(2021, 11, 21));
		flightOne.setType(FlightType.International);
		flightOne.setDurationMin(80);
		flightOne.setAircraft(new Aircraft("737", 180));
		
		FlightInformation flightTwo = new FlightInformation();
		flightTwo.setId("15");
		flightTwo.setDelayed(false);
		flightTwo.setDepartureCity(paris);
		flightTwo.setDestinationCity(copenhagen);
		flightTwo.setDepartureDate(LocalDate.of(2021, 11, 21));
		flightTwo.setType(FlightType.International);
		flightTwo.setDurationMin(600);
		flightTwo.setAircraft(new Aircraft("737", 180));
		
		//Seed
		List<Airport> airports = Arrays.asList(rome, paris, copenhagen);
		this.airportRepository.insert(airports);
		
		List<FlightInformation> flights = Arrays.asList(flightOne, flightTwo);
		this.flightInformationRepository.insert(flights);
		
		// Print
		FlightPrinter.print(flights);
	}

	private void empty() {
		flightInformationRepository.deleteAll();
	}
}
