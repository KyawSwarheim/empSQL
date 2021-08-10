package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Employee;
import com.emp.mydb.Empdb.request.EmployeeRequest;


@Service
public interface EmpService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(EmployeeRequest employeeRequest);
	
	void deleteEmployee(long id);

	Employee findById(Long employeeId);
	
	Employee addEmployeewithRole(EmployeeRequest employeeRequest);

}
