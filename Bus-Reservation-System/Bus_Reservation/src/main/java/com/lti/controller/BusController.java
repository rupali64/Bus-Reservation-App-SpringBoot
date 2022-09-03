package com.lti.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bus;
import com.lti.exception.BusNotFoundException;
import com.lti.service.BusService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/bus")
public class BusController {
		
	@Autowired(required = true)
	BusService busService;
	
	@PostMapping("/addBus")
	@ExceptionHandler(BusNotFoundException.class)
	public Bus addBus(@RequestBody Bus bus) {
		return busService.addBus(bus);
	}

	@GetMapping("/allBus")
	public Iterable<Bus> getAllBusDetails() {
		return busService.getAllBusDetails();
	}

	@PutMapping("/modifyBus")
	public Bus modifyBus(@RequestBody String busPlateNo, Bus bus) throws BusNotFoundException {
		return busService.modifyBus(busPlateNo,bus);
	}

	@DeleteMapping("/deleteBus/{id}")
	public Bus deleteBus(@RequestBody String busPlateNo) throws BusNotFoundException {
		return busService.deleteBus(busPlateNo);
	}
	
	@GetMapping("/busPlateNumber")
	public Bus  findBusByBusPlateNumber(@RequestBody String busPlateNo) throws BusNotFoundException {
		return busService.deleteBus(busPlateNo);
	}
}
