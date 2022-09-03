package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Integer> {
	Bus findByBusPlateNo(String busPlateNO);
}
