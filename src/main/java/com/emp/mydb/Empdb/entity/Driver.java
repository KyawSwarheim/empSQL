package com.emp.mydb.Empdb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long driverId;	
	private String name;
	private String phone;
	private String nrc;
	private String gender;
	private String license;
	private String address;
	private String action;
	
	public Driver() {
	}

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", phone=" + phone + ", nrc=" + nrc + ", gender="
				+ gender + ", license=" + license + ", address=" + address + ", action=" + action + "]";
	}
}
