package com.lti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Schedule;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Integer> {
	List<Schedule> findBystartingPointAndDestinationAndScheduleDate(String startingPoint, String endingPoint, String scheduleDate);
	List<Schedule> findBystartingPointAndDestination(String startingPoint, String endingPoint);
}
