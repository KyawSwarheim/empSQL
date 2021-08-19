package com.emp.mydb.Empdb.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emp.mydb.Empdb.Service.EmpService;
import com.emp.mydb.Empdb.entity.Employee;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.request.EmployeeRequest;

@RestController
@RequestMapping("/api/employees")
public class EmpController {
	
	@Autowired
	private EmpService empService;

	public EmpController(EmpService empService) {
		super();
		this.empService = empService;
	}
	
	//build get all employee Rest API
	@GetMapping()
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	//build get employee by id Rest API
	//http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long EmpolyeeId){
		try {
			return new ResponseEntity<Employee>(empService.findById(EmpolyeeId), HttpStatus.OK);
	}catch (ResourceNotFoundException e) {
		System.out.print(e);
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	//build update employee Rest API
	//http://localhost:8080/api/employees/1
	@PutMapping()
	public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeRequest employeeRequest){
		return new ResponseEntity<Employee>(empService.updateEmployee(employeeRequest), HttpStatus.OK);
		
	}	
	//build delete employee Rest API
	//http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
		//delete employee from DB
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted Successfuly!", HttpStatus.OK);
	}
	
//	//build many to many
//	@PutMapping("/{employeeId}/role/{roleId}")
//	Employee employeeToRole(@PathVariable long employeeId,
//							@PathVariable long roleId) {
//		Employee employee = empService.findById(employeeId);
//		Role role = roleService.findById(roleId);
//		employee.roles(role);
//		return empService.saveEmployee(employee);
//	}
	@PostMapping()
	public Employee addEmployee(@RequestBody EmployeeRequest employeeRequest) {
		return empService.addEmployeewithRole(employeeRequest);
		
	}
	
}
