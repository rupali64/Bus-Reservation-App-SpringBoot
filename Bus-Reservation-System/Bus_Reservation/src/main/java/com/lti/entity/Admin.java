package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sysAdmin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private int adminId;
	@Column(name = "admin_name")
	private String adminName;
	@Column(name = "admin_password")
	private String password;
	@Column(name = "admin_email")
	private String email;
	
	public Admin() {}
	
	public Admin(String adminName, String password, String email) {
		this.adminName = adminName;
		this.password = password;
		this.email = email;
	}

	public Admin(int adminId, String adminName, String password, String email) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password + ", email=" + email
				+ "]";
	}
	
}
