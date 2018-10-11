package com.apap.tutorial5.service;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.PilotDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDB pilotDB;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDB.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDB.save(pilot);
	}
	@Override
	public void deletePilot(String licenseNumber) {
		PilotModel removedPilot = pilotDB.findByLicenseNumber(licenseNumber);
		pilotDB.delete(removedPilot);
	}
//	public PilotServiceImpl() {
//		// TODO Auto-generated constructor stub
//	}

}
