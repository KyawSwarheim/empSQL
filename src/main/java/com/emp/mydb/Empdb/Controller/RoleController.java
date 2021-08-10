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
import com.emp.mydb.Empdb.Service.RoleService;
import com.emp.mydb.Empdb.entity.Employee;
import com.emp.mydb.Empdb.entity.Role;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("api/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;

	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	
		@PostMapping()
		public ResponseEntity<Role> saveRole(@RequestBody Role role){
			return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.CREATED);
		}
		
		@GetMapping()
		public List<Role> getAllRoles(){
			return roleService.getAllRoles();
		}
		@GetMapping("{id}")
		public ResponseEntity<Role> getRoleById(@PathVariable("id")long RoleId){
			try {
				return new ResponseEntity<Role>(roleService.getRoleById(RoleId), HttpStatus.OK);
		}catch (ResourceNotFoundException e) {
			System.out.print(e);
			DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
			return new ResponseEntity(defaultReponse,HttpStatus.NOT_FOUND);
			}
		}
		@PutMapping()
		public ResponseEntity<Role> updateRole(@RequestBody Role role){
			return new ResponseEntity<Role>(roleService.updateRole(role), HttpStatus.OK);
			
		}
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteRole(@PathVariable("id")long id){
			//delete employee from DB
			roleService.deleteRole(id);
			return new ResponseEntity<String>("Role deleted Successfuly!", HttpStatus.OK);
		}
}
