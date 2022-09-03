package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.BusDao;
import com.lti.dao.ScheduleDao;
import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Schedule;
import com.lti.entity.User;
import com.lti.exception.AdminNotFoundException;
import com.lti.exception.UserNotFoundException;



@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao admindao;
	
	
	public List<Admin> getAllAdminDetails() {
		
		return admindao.findAll();
		
		
	}
	@Override
	public Admin findAdminById(int adminid) throws AdminNotFoundException{
		Optional<Admin> admin = admindao.findById(adminid);
			if(!(admin.isPresent())) {
				throw new AdminNotFoundException("Admin id: " + adminid + "not found");
			}
		return admin.get();
	}
	@Override
	public Admin addAdmin(Admin newAdmin) {
		// TODO Auto-generated method stub
		Optional<Admin> findAdminById = admindao.findById(newAdmin.getAdminId());
		
		if (!findAdminById.isPresent()) {
			 admindao.save(newAdmin);		
			 }
		return newAdmin;

		
	}
	
	
	@Override
	public Admin findByAdminName(String adminName) throws AdminNotFoundException {
		Optional<Admin> admin= admindao.findByAdminName(adminName);
		if(!admin.isPresent()) {
			throw new AdminNotFoundException("Admin name: " + adminName + "");
		}
		return admin.get();
		
	}
	
}
