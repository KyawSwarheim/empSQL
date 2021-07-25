package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.entity.Employee;

@Service
public interface EmpService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);

}
