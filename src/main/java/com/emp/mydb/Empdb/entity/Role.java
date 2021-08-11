package com.emp.mydb.Empdb.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="role")
public class Role{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="role_id")
	private long id;

	@Column(name = "rolename")
	private String rolename;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<Employee> employees = new HashSet<>();
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Role() {
		super();
	}	
	public Role(long id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public void addEmployee(Employee employee) {
		this.employees.add(employee);		
	}
	
}
