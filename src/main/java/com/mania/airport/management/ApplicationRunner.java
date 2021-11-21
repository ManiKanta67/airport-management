package com.mania.airport.management;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.mania.airport.management.domain.Airport;
import com.mania.airport.management.domain.FlightInformation;
import com.mania.airport.management.repository.AirportRepository;
import com.mania.airport.management.repository.FlightInformationRepository;

/*
 * In spring boot, a class that implements CommandLineRunner is executed after the application is bootstrapped.
 */

@Service
@Order(2)
public class ApplicationRunner implements CommandLineRunner {

	// This is main class that executes queries against database.
	private FlightInformationRepository flightInformationRepository;
	private AirportRepository airportRepository;

	public ApplicationRunner(FlightInformationRepository flightInformationRepository, AirportRepository airportRepository) {
		this.flightInformationRepository = flightInformationRepository;
		this.airportRepository = airportRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// Single update
		Airport rome = this.airportRepository.findById("11").get();
		rome.setName("Lenonardo da Vinci (Flumicino)");
		this.airportRepository.save(rome);
		
		System.out.println("-> AFTER UPDATE TO ROME");
		List<FlightInformation> flights = this.flightInformationRepository.findAll();
		FlightPrinter.print(flights);
	}
}
