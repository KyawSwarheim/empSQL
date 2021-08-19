package com.emp.mydb.Empdb.ServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.EmpRepository;
import com.emp.mydb.Empdb.Service.EmpService;
import com.emp.mydb.Empdb.entity.Employee;
import com.emp.mydb.Empdb.entity.Role;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.request.EmployeeRequest;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;

	@Autowired
	private RoleServiceImpl roleServiceImpl;

	public EmpServiceImpl(EmpRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return empRepository.findAll();
	}
	
	@Override
	public Employee findById(long employeeId) {
//		Optional<Employee> employee = empRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return empRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
	}

	@Override
	public Employee updateEmployee(EmployeeRequest employeeRequest) {
		// we need t check whether employee with given id is exit in DB or not
		Employee exitingEmployee = findById(employeeRequest.getId());
		Set<Role> roles = new HashSet<>();
		Role role = roleServiceImpl.findById(employeeRequest.getRole_id());
		roles.add(role);
		exitingEmployee.setFirstname(employeeRequest.getFirstname());
		exitingEmployee.setLastname(employeeRequest.getLastname());
		exitingEmployee.setEmail(employeeRequest.getEmail());
		exitingEmployee.setRoles(roles);
		// save existing employee to DB
		empRepository.save(exitingEmployee);
		return exitingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist in a DB or Not
		empRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		empRepository.deleteById(id);
	}

	@Override
	public Employee addEmployeewithRole(EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		Set<Role> roles = new HashSet<>();
		Role role = roleServiceImpl.findById(employeeRequest.getRole_id());
		roles.add(role);
		employee.setFirstname(employeeRequest.getFirstname());
		employee.setLastname(employeeRequest.getLastname());
		employee.setEmail(employeeRequest.getEmail());
		employee.setRoles(roles);
		return empRepository.save(employee);

	}

}
