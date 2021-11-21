package com.mania.airport.management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mania.airport.management.domain.FlightInformation;

/*
 * In spring boot, a class that implements CommandLineRunner is executed after the application is bootstrapped.
 */

@Component
public class ApplicationRunner implements CommandLineRunner {

	// This is main class that executes queries against database.
	private MongoTemplate mongoTemplate;
	
	public ApplicationRunner(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public void run(String ...args) throws Exception
	{
		FlightInformation emtpyFlight = new FlightInformation();
		this.mongoTemplate.save(emtpyFlight);
		System.out.println("Application started...");
	}
}
