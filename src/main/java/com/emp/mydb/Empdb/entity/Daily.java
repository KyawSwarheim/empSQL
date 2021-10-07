package com.emp.mydb.Empdb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Daily {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dailyId;
	private String transactionCode;
	private String driver;
	private String car;
	private String startDate;
	private String endDate;
	private String daily;
	private String days;
	private String total;
	private String paid;
	private String remain;
	private String remark;
	public Daily() {
	}
	public long getDailyId() {
		return dailyId;
	}
	public void setDailyId(long dailyId) {
		this.dailyId = dailyId;
	}
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
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
	public String getDaily() {
		return daily;
	}
	public void setDaily(String daily) {
		this.daily = daily;
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
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Daily [dailyId=" + dailyId + ", transactionCode=" + transactionCode + ", driver=" + driver + ", car="
				+ car + ", startDate=" + startDate + ", endDate=" + endDate + ", daily=" + daily + ", days=" + days
				+ ", total=" + total + ", paid=" + paid + ", remain=" + remain + ", remark=" + remark + "]";
	}
	
	
}
