package com.emp.mydb.Empdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.emp.mydb.Empdb.Repository.EmpRepository;
import com.emp.mydb.Empdb.Repository.RoleRepository;

@SpringBootApplication
public class EmpdbApplication {
	
	@Autowired
	EmpRepository empRespository;
	
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmpdbApplication.class, args);
	}

}
