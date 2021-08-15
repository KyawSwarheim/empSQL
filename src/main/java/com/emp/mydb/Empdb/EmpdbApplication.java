package com.emp.mydb.Empdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.emp.mydb.Empdb.Repository.EmpRepository;
import com.emp.mydb.Empdb.Repository.RoleRepository;
import com.emp.mydb.Empdb.Repository.SalaryRepository;
import com.emp.mydb.Empdb.Repository.TeacherRepository;

@SpringBootApplication
public class EmpdbApplication {
	
	@Autowired
	EmpRepository empRespository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	SalaryRepository salaryRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmpdbApplication.class, args);
	}

}
