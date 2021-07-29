package com.emp.mydb.Empdb.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.EmpRepository;
import com.emp.mydb.Empdb.entity.Employee;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;


@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpRepository empRepository;

	public EmpServiceImpl(EmpRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return empRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = empRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return empRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// we need t check whether employee with given id is exit in DB or not
		Employee exitingEmployee = getEmployeeById(employee.getId());
		
		exitingEmployee.setFirstname(employee.getFirstname());
		exitingEmployee.setLastname(employee.getLastname());
		exitingEmployee.setEmail(employee.getEmail());
		
		//save existing employee to DB
		empRepository.save(exitingEmployee);
		return exitingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist in a DB or Not
		empRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		empRepository.deleteById(id);
		
	}

}
