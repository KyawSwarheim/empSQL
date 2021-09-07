package com.emp.mydb.Empdb.request;

import java.io.Serializable;
import java.util.Set;

import com.emp.mydb.Empdb.entity.Role;

public class EmployeeRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String firstname;
	private String lastname;
	private String email;	
	public Set<Role> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", roles=" + roles + "]";
	}
	
}
