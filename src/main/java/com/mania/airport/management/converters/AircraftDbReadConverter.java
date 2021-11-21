package com.mania.airport.management.converters;

import org.springframework.core.convert.converter.Converter;

import com.mania.airport.management.domain.Aircraft;

public class AircraftDbReadConverter implements Converter<String, Aircraft> {

	@Override
	public Aircraft convert(String s) {
		if (s == null)
			return null;

		String[] parts = s.split("/");
		Aircraft aircraft = new Aircraft(parts[0], Integer.parseInt(parts[1]));
		return aircraft;
	}

}
