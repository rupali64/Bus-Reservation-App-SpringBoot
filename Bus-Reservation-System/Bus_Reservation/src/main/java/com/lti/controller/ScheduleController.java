package com.lti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Schedule;
import com.lti.exception.BusNotFoundException;
import com.lti.exception.RecordNotFoundException;
import com.lti.service.BusService;
import com.lti.service.ScheduleService;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/scheduledBus")
public class ScheduleController {
	/*
	 * Creating Service object
	 */
	@Autowired
	ScheduleService scheduleService;

	@Autowired
	BusService busService;

	/*
	 * Controller for adding Scheduled Bus
	 */
	@PostMapping("/addSchedule")
	public Schedule addScheduledBus(@RequestBody Schedule scheduledBus) {
		return scheduleService.addScheduledBus(scheduledBus);
		
	}
	
	/*
	 * Controller for viewing all Scheduled Bus
	 */
	@GetMapping("/viewAll")
	public Iterable<Schedule> viewAllSF() {
		return scheduleService.viewAllScheduledBuses();
	}
	
	/*
	 * Controller for modifying existing Scheduled Bus
	 */
	@PutMapping("/modify")
	public ResponseEntity<Schedule> modifyScheduleBus(@ModelAttribute Schedule scheduleBus) {
		Schedule modifyBus = scheduleService.modifyScheduledBus(scheduleBus);
		if (modifyBus == null) {
			return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Schedule>(modifyBus, HttpStatus.OK);
		}

	}
	
	/*
	 * Controller for deleting existing Scheduled Bus
	 */
	
	@DeleteMapping("/delete")
	public String deleteSF(@RequestParam Integer flightId) throws RecordNotFoundException {
		return scheduleService.removeScheduledBus(flightId);
	}
	
	/*
	 * Controller for viewing a Scheduled Bus by ID
	 */
	@GetMapping("/search")
	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<Schedule> viewSF(@RequestParam Integer busId) throws BusNotFoundException {
		Schedule searchSBus = scheduleService.viewScheduledBus(busId);
		if (searchSBus == null) {
			return new ResponseEntity("Bus not present", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Schedule>(searchSBus, HttpStatus.OK);
		}
	}
	
	@GetMapping("/schedules/{startingPoint}/{destination}")
	public List<Schedule> fetchSchedules(@PathVariable("startingPoint") String startingPoint, @PathVariable("destination") String destination){
		return this.scheduleService.findBystartingPointAndDestination(startingPoint, destination);
	}
	
	@GetMapping("/schedules/{startingPoint}/{destination}/{scheduleDate}")
	public List<Schedule> fetchSchedulesByDate(@PathVariable("startingPoint") String startingPoint, @PathVariable("destination") String destination, @PathVariable("scheduleDate") String scheduleDate){
		return this.scheduleService.findBystartingPointAndDestinationAndScheduleDate(startingPoint, destination, scheduleDate);
	}
	
	
}
