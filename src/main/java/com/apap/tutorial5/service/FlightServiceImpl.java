package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.repository.FlightDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDB flightDB;
	
	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDB.findByFlightNumber(flightNumber);
	}
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDB.save(flight);
	}
	
	@Override
	public void deleteFlight(long id) {
		FlightModel removedFlight = flightDB.findById(id);
		flightDB.delete(removedFlight);
	}
}
