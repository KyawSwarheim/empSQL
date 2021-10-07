package com.emp.mydb.Empdb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Maintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maintenanceId;
	private String car;
	private String shop;
	private String startDate;
	private String endDate;
	private String days;
	private String total;
	public Maintenance() {
	}
	public long getMaintenanceId() {
		return maintenanceId;
	}
	public void setMaintenanceId(long maintenanceId) {
		this.maintenanceId = maintenanceId;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Maintenance [maintenanceId=" + maintenanceId + ", car=" + car + ", shop=" + shop + ", startDate="
				+ startDate + ", endDate=" + endDate + ", days=" + days + ", total=" + total + "]";
	}
	
}
