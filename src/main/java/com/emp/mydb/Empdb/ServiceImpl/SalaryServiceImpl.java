package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.SalaryRepository;
import com.emp.mydb.Empdb.Service.SalaryService;
import com.emp.mydb.Empdb.entity.Salary;

@Service
public class SalaryServiceImpl implements SalaryService {
	
	@Autowired
	SalaryRepository salaryRepository;

	@Override
	public Salary saveSalary(Salary salary) {
		return salaryRepository.save(salary);
	}

	@Override
	public List<Salary> getAllSalarys() {
		return salaryRepository.findAll();
	}

	@Override
	public Salary findById(long salaryrId) {
		return salaryRepository.getById(salaryrId);
	}

	@Override
	public Salary getSalaryById(long id) {
		return salaryRepository.findById(id);
	}

	@Override
	public Salary updateSalary(Salary salary) {
		Salary exitingSalary = getSalaryById(salary.getId());
		exitingSalary.setPrice(salary.getPrice());
		
		salaryRepository.save(exitingSalary);
		return exitingSalary;
	}

	@Override
	public void deleteSalary(long id) {
		salaryRepository.deleteById(id);
		
	}

}
