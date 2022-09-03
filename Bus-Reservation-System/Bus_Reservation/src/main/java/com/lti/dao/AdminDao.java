package com.lti.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer>{

	Optional<Admin> findByAdminName(String adminName);

}
