package com.emp.mydb.Empdb.request;

public class TeacherRequest{
    private long id;
    private String name;
    private String subject;
    private String development;
    private long salaryId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDevelopment() {
		return development;
	}
	public void setDevelopment(String development) {
		this.development = development;
	}
	public long getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(long salaryId) {
		this.salaryId = salaryId;
	}
	
}
