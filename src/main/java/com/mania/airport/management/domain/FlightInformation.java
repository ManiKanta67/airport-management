package com.mania.airport.management.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("flights")
public class FlightInformation {

	@Id
	private String id;
	
	@Field("departure")
	@Indexed
	private String departureCity;
	
	@Field("destination")
	@Indexed
	private String destinationCity;
	private FlightType type;
	private boolean isDelayed;
	private int durationMin;
	private LocalDate departureDate;
	private Aircraft aircraft;
	
	@Transient
	private LocalDate createdAt;

	public FlightInformation() {
		this.createdAt = LocalDate.now();
	}

	public String getId() {
		return id;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public FlightType getType() {
		return type;
	}

	public boolean isDelayed() {
		return isDelayed;
	}

	public int getDurationMin() {
		return durationMin;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}
}
