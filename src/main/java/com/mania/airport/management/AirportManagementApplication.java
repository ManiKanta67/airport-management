package com.mania.airport.management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.mania.airport.management.converters.AircraftDbReadConverter;
import com.mania.airport.management.converters.AircraftDbWriteConverter;

@SpringBootApplication
public class AirportManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportManagementApplication.class, args);
	}
	
	@Bean
	public MongoCustomConversions customConversions()
	{
		List<Converter<?,?>> converters = new ArrayList<>();
		converters.add(new AircraftDbReadConverter());
		converters.add(new AircraftDbWriteConverter());
		return new MongoCustomConversions(converters);
	}
}
