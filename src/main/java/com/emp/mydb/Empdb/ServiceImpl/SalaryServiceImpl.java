package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.SalaryRepository;
import com.emp.mydb.Empdb.Service.SalaryService;
import com.emp.mydb.Empdb.entity.Salary;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

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
	public Salary findById(long salaryId) {
		return salaryRepository.findById(salaryId)
			.orElseThrow(()-> new ResourceNotFoundException("Salary ", "Id", salaryId));
	}

	@Override
	public Salary updateSalary(Salary salary) {
		Salary exitingSalary = findById(salary.getId());
		exitingSalary.setPrice(salary.getPrice());	
		salaryRepository.save(exitingSalary);
		return exitingSalary;
	}

	@Override
	public void deleteSalary(long id) {
		salaryRepository.deleteById(id);		
	}

}
