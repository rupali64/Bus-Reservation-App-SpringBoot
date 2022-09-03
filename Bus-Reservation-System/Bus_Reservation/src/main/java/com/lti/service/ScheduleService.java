package com.lti.service;

import java.util.List;

import com.lti.entity.Bus;
import com.lti.entity.Schedule;
import com.lti.exception.BusNotFoundException;
import com.lti.exception.RecordNotFoundException;

public interface ScheduleService {
	
	List<Schedule> viewAllScheduledBuses();
	
	 Schedule addScheduledBus(Schedule scheduledBus);

	 Schedule modifyScheduledBus(Schedule scheduledBus);

	 String removeScheduledBus(int id) throws RecordNotFoundException;

	 Schedule viewScheduledBus(int id) throws BusNotFoundException;
	 
	 List<Schedule> findBystartingPointAndDestinationAndScheduleDate(String startingPoint, String endingPoint, String scheduleDate);
	 
	 List<Schedule> findBystartingPointAndDestination(String startingPoint, String endingPoint);
}
