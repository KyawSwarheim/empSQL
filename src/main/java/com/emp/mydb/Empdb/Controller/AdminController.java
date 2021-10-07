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
import com.emp.mydb.Empdb.Service.AdminService;
import com.emp.mydb.Empdb.entity.Admin;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping()
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        System.out.println("post controller " + admin);
        return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Admin>> getAllAdmin() {
        System.out.println("get Admin controller ");
        return new ResponseEntity<List<Admin>>(adminService.getAllAdmin(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getAdminById(@PathVariable("id") long id) {
        try {
            System.out.println("get by id Admin " + id);
            return new ResponseEntity<Object>(adminService.findId(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            System.out.print(e);
            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
        System.out.println("update Admin " + admin);
        return new ResponseEntity<Admin>(adminService.updateAdmin(admin), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteSalary(@RequestParam(name="id") long id) {
        System.out.println("update Admin " + id);
        adminService.deleteAdmin(id);
        return new ResponseEntity<String>("Admin deleted Successfuly!", HttpStatus.OK);
    }

}
