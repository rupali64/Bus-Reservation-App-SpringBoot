package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
import com.lti.exception.AdminNotFoundException;
import com.lti.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {
		
	@Autowired
	AdminService adminservice;
		
	@GetMapping("/searchadminById/{id}")
	@ExceptionHandler(AdminNotFoundException.class)
	public Admin searchBookingByID(@PathVariable("id") int adminId) throws AdminNotFoundException {

		return adminservice.findAdminById(adminId);
	}
	
	@PostMapping("/addadmin")
	@ExceptionHandler(AdminNotFoundException.class)
	public Admin addAdmin(@RequestBody Admin admin) {
		return  adminservice.addAdmin(admin);
	}
	
	
	@GetMapping("/getAdminName/{name}")
	@ExceptionHandler(AdminNotFoundException.class)
	public Admin findByAdminName(@PathVariable("name") String adminName) throws AdminNotFoundException {
		return adminservice.findByAdminName(adminName);
	}
}