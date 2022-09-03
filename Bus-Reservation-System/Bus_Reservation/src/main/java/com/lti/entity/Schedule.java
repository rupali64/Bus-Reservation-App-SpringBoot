package com.lti.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_id")
	private int scheduleId;
//	@Column(name = "busId")
//	private int busId;
	@Column(name = "starting_point")
	private String startingPoint;
	@Column(name = "destination")
	private String destination;
	@Column(name = "fare_amount")
	private double fareAmount;
	@Column(name = "arrival_time")
	private String estimatedArrivalTime;
	@Column(name = "departure_time")
	private String departureTime;
	@Column(name = "departure_date")
	private String scheduleDate;
	
	@Autowired
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bus_id")
	private Bus bus;
	
	public Schedule() {}
	
	public Schedule(String startingPoint, String destination, double fareAmount,
			String estimatedArrivalTime, String departureTime, String scheduleDate, Bus bus) {
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.fareAmount = fareAmount;
		this.estimatedArrivalTime = estimatedArrivalTime;
		this.departureTime = departureTime;
		this.scheduleDate = scheduleDate;
		this.bus = bus;
	}

	public Schedule(int scheduleId, String startingPoint, String destination, double fareAmount,
			String estimatedArrivalTime, String departureTime, String scheduleDate, Bus bus) {
		this.scheduleId = scheduleId;
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.fareAmount = fareAmount;
		this.estimatedArrivalTime = estimatedArrivalTime;
		this.departureTime = departureTime;
		this.scheduleDate = scheduleDate;
		this.bus = bus;
	}


	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFareAmount() {
		return fareAmount;
	}

	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}

//	public Bus getBus() {
//		return bus;
//	}
//
//	public void setBus(Bus bus) {
//		this.bus = bus;
//	}

	public String getEstimatedArrivalTime() {
		return estimatedArrivalTime;
	}

	public void setEstimatedArrivalTime(String estimatedArrivalTime) {
		this.estimatedArrivalTime = estimatedArrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", startingPoint=" + startingPoint + ", destination="
				+ destination + ", fareAmount=" + fareAmount + ", estimatedArrivalTime=" + estimatedArrivalTime
				+ ", departureTime=" + departureTime + ", scheduleDate=" + scheduleDate + ", bus=" + bus + "]";
	}
	
}
