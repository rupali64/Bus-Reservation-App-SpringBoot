package com.lti.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bus_details")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bus_id")
	private int busId;
	@Column(name = "bus_plateno")
	private String busPlateNo;
	@Column(name = "bus_capacity")
	private int capacity;
	@Column(name = "bus_type")
	private String busType;
	
	private String[] alreadyBookedSeats;
	
	public String[] getAlreadyBookedSeats() {
		return alreadyBookedSeats;
	}

	public void setAlreadyBookedSeats(String[] alreadyBookedSeats) {
		this.alreadyBookedSeats = alreadyBookedSeats;
	}

	public Bus() {}
	
	public Bus(String busPlateNo, int capacity, String busType) {
		this.busPlateNo = busPlateNo;
		this.capacity = capacity;
		this.busType = busType;
	}
	
	public Bus(int busId, String busPlateNo, int capacity, String busType) {
		super();
		this.busId = busId;
		this.busPlateNo = busPlateNo;
		this.capacity = capacity;
		this.busType = busType;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusPlateNo() {
		return busPlateNo;
	}

	public void setBusPlateNo(String busPlateNo) {
		this.busPlateNo = busPlateNo;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busPlateNo=" + busPlateNo + ", capacity=" + capacity + ", busType=" + busType
				+ ", alreadyBookedSeats=" + Arrays.toString(alreadyBookedSeats) + "]";
	}

	
	
}
