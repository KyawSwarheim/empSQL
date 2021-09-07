package com.emp.mydb.Empdb.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long role_id;

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

	public Role(long role_id, String rolename) {
		super();
		this.role_id = role_id;
		this.rolename = rolename;
	}

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", rolename=" + rolename + ", employees=" + employees + "]";
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
		
	}

}
