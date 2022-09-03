package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer>{

}
