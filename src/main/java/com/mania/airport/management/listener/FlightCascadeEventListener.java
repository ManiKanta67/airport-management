package com.mania.airport.management.listener;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.mania.airport.management.domain.Airport;
import com.mania.airport.management.domain.FlightInformation;

/*
 * De registering this as component as this is replaced by GenericCascadeEventListener which work all parent child object
 * unlike this specific one which works only for FlightInformation and Airport.
 */
// @Component
public class FlightCascadeEventListener extends AbstractMongoEventListener<Object> {
	private MongoTemplate mongoTemplate;

	public FlightCascadeEventListener(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
		Object doc = event.getSource();
		if ((doc instanceof FlightInformation) && (((FlightInformation) doc).getDepartureCity() != null)) {
			Airport departure = ((FlightInformation) doc).getDepartureCity();
			mongoTemplate.save(departure);
		}

		if ((doc instanceof FlightInformation) && (((FlightInformation) doc).getDestinationCity() != null)) {
			Airport destination = ((FlightInformation) doc).getDestinationCity();
			mongoTemplate.save(destination);
		}
	}
}
