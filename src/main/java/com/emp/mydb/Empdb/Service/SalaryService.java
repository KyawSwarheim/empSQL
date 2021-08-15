package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Salary;

@Service
public interface SalaryService {
	
	Salary saveSalary(Salary salary);
	
	List<Salary> getAllSalarys();

	Salary findById(long salaryrId);
	
	Salary getSalaryById(long id);
	
	Salary updateSalary(Salary salary);
	
	void deleteSalary(long id);

}
