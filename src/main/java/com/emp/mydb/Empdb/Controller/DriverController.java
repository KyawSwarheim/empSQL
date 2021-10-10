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

import com.emp.mydb.Empdb.Service.DriverService;
import com.emp.mydb.Empdb.entity.Driver;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin(origins = "*")
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@PostMapping()
    public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver) {
        System.out.println("post controller " + driver);
        return new ResponseEntity<Driver>(driverService.saveDriver(driver), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Driver>> getAllDriver() {
        System.out.println("get Driver controller ");
        return new ResponseEntity<List<Driver>>(driverService.getAllDriver(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getDriverById(@PathVariable("id") long id) {
        try {
            System.out.println("get by id Driver " + id);
            return new ResponseEntity<Object>(driverService.findId(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            System.out.print(e);
            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
        System.out.println("update Driver " + driver);
        return new ResponseEntity<Driver>(driverService.updateDriver(driver), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteDriver(@RequestParam(name="id") long id) {
        System.out.println("update Driver " + id);
        driverService.deleteDriver(id);
        return new ResponseEntity<String>("Driver deleted Successfuly!", HttpStatus.OK);
    }

}
