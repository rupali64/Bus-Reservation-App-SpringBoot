package com.lti.service;

import java.util.List;
import java.util.Optional;

import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Schedule;
import com.lti.exception.AdminNotFoundException;



public interface AdminService {
	List <Admin> getAllAdminDetails();
	Admin findAdminById(int adminid) throws AdminNotFoundException ;
	Admin addAdmin(Admin newAdmin);
	Admin findByAdminName(String AdminName) throws AdminNotFoundException;
}
