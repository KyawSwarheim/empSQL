package com.emp.mydb.Empdb.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.emp.mydb.Empdb.Service.RolesService;
import com.emp.mydb.Empdb.entity.Roles;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolesController {
	
	@Autowired
	RolesService rolesService;
	
	@PostMapping()
    public ResponseEntity<Roles> saveRoles(@RequestBody Roles roles) {
        System.out.println("post controller " + roles);
        return new ResponseEntity<Roles>(rolesService.saveRoles(roles), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Roles>> getAllRoles() {
        System.out.println("get Roles controller ");
        return new ResponseEntity<List<Roles>>(rolesService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getRolesById(@PathVariable("id") long id) {
        try {
            System.out.println("get by id Roles " + id);
            return new ResponseEntity<Object>(rolesService.findId(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            System.out.print(e);
            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Roles> updateMaintenance(@RequestBody Roles roles) {
        System.out.println("update Roles " + roles);
        return new ResponseEntity<Roles>(rolesService.updateRoles(roles), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteRoles(@RequestParam(name="id") long id) {
        System.out.println("update Maintenance " + id);
        rolesService.deleteRoles(id);
        return new ResponseEntity<String>("Roles deleted Successfuly!", HttpStatus.OK);
    }

}
