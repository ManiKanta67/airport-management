package com.mania.airport.management.domain;

public class Aircraft {

	private String model;
	private int nbSeats;

	public Aircraft(String model, int nbSeats) {
		super();
		this.model = model;
		this.nbSeats = nbSeats;
	}

	public String getModel() {
		return model;
	}

	public int getNbSeats() {
		return nbSeats;
	}
}
