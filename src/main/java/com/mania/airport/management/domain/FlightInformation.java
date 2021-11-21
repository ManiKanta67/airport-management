package com.mania.airport.management.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("flights")
public class FlightInformation {

	@Id
	private String id;

	@Indexed(unique= true)
	private String internalId;
	
	@DBRef
	private Airport departure;

	@DBRef
	private Airport destination;

	@TextIndexed(weight = 2)
	private String description;

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

	public void setId(String id) {
		this.id = id;
	}

	public void setDepartureCity(Airport departureCity) {
		this.departure = departureCity;
	}

	public void setDestinationCity(Airport destinationCity) {
		this.destination = destinationCity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(FlightType type) {
		this.type = type;
	}

	public void setDelayed(boolean isDelayed) {
		this.isDelayed = isDelayed;
	}

	public void setDurationMin(int durationMin) {
		this.durationMin = durationMin;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public Airport getDepartureCity() {
		return departure;
	}

	public Airport getDestinationCity() {
		return destination;
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
