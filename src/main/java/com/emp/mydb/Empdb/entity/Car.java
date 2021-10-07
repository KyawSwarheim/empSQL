package com.emp.mydb.Empdb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carId;
	private String carNo;
	private String brand;
	private String name;
	private String modelYear;
	private String startDate;
	private String color;
	private String taxiNumber;
	private String licenseMonth;
	private String daily;
	private String action;	
	public Car() {
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTaxiNumber() {
		return taxiNumber;
	}
	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}
	public String getLicenseMonth() {
		return licenseMonth;
	}
	public void setLicenseMonth(String licenseMonth) {
		this.licenseMonth = licenseMonth;
	}
	public String getDaily() {
		return daily;
	}
	public void setDaily(String daily) {
		this.daily = daily;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carNo=" + carNo + ", brand=" + brand + ", name=" + name + ", modelYear="
				+ modelYear + ", startDate=" + startDate + ", color=" + color + ", taxiNumber=" + taxiNumber
				+ ", licenseMonth=" + licenseMonth + ", daily=" + daily + ", action=" + action + "]";
	}
}
