package com.mania.airport.management.converters;

import org.springframework.core.convert.converter.Converter;

import com.mania.airport.management.domain.Aircraft;

public class AircraftDbWriteConverter implements Converter<Aircraft, String> {
	@Override
	public String convert(Aircraft aircraft) {
		return aircraft.getModel() + "/" + aircraft.getNbSeats();
	}
}
