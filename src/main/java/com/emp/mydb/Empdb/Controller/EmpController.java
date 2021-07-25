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

@RestController
@RequestMapping("/api/employees")
public class EmpController {
	
	@Autowired
	private EmpService empService;

	public EmpController(EmpService empService) {
		super();
		this.empService = empService;
	}
	
	//build create employee Rest API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empService.saveEmployee(employee), HttpStatus.CREATED);
	}
	//build get all employee Rest API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	//build get employee by id Rest API
	//http:localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long EmpolyeeId){
		return new ResponseEntity<Employee>(empService.getEmployeeById(EmpolyeeId), HttpStatus.OK);
	}
	//build update employee Rest API
	//http:localhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
													,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empService.updateEmployee(employee, id), HttpStatus.OK);
		
	}
	
	//build delete employee Rest API
	//http:localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long id){
		//delete employee from DB
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted Successfuly!", HttpStatus.OK);
	}
}
