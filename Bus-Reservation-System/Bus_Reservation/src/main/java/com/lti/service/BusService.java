package com.lti.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lti.entity.Bus;
import com.lti.exception.BusNotFoundException;

public interface BusService {
	public List<Bus> getAllBusDetails();
	public Bus findBusByBusPlateNumber(String busPlateNo) throws BusNotFoundException;
	public Bus addBus(Bus bus);
	public Bus modifyBus(String busPlateNo, Bus bus) throws BusNotFoundException;
	public Bus deleteBus(String busPlateNo) throws BusNotFoundException;
	public Bus findBusById(int busId) throws BusNotFoundException;
}
