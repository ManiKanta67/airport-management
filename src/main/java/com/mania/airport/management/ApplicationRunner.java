package com.mania.airport.management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mania.airport.management.domain.FlightInformation;

/*
 * In spring boot, a class that implements CommandLineRunner is executed after the application is bootstrapped.
 */

@Service
@Order(2)
public class ApplicationRunner implements CommandLineRunner {

	// This is main class that executes queries against database.
	private MongoTemplate mongoTemplate;

	public ApplicationRunner(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		markAllFlightsToRomeAsDelayed();
		removeFlightsWithDurationLessThanTwoHours();
	}

	private void removeFlightsWithDurationLessThanTwoHours() {
		Query departingFromRome = Query.query(Criteria.where("destination").is("Rome"));
		Update setDelayed = Update.update("isDelayed", true);
		this.mongoTemplate.updateMulti(departingFromRome, setDelayed, FlightInformation.class);
	}

	private void markAllFlightsToRomeAsDelayed() {
		Query lessThanTwoHours = Query.query(Criteria.where("duration").lt(120));
		mongoTemplate.findAllAndRemove(lessThanTwoHours, FlightInformation.class);
	}
}
