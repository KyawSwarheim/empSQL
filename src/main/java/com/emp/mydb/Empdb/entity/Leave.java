package com.emp.mydb.Empdb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaveId;
	private String driver;
	private String car;
	private String startDate;
	private String endDate;
	private String days;
	private String reason;
	public Leave() {
	}
	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", driver=" + driver + ", car=" + car + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", days=" + days + ", reason=" + reason + "]";
	}
	
}
