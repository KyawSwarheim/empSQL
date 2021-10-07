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

import com.emp.mydb.Empdb.Service.CarService;
import com.emp.mydb.Empdb.entity.Car;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = "*")
public class CarController {
	
	@Autowired
	CarService carService;
	
	 @PostMapping()
	    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
	        System.out.println("post controller " + car);
	        return new ResponseEntity<Car>(carService.saveCar(car), HttpStatus.CREATED);
	    }

	    @GetMapping()
	    public ResponseEntity<List<Car>> getAllCar() {
	        System.out.println("get Car controller ");
	        return new ResponseEntity<List<Car>>(carService.getAllCar(), HttpStatus.OK);
	    }

	    @GetMapping("{id}")
	    public ResponseEntity<Object> getCarById(@PathVariable("id") long id) {
	        try {
	            System.out.println("get by id Car " + id);
	            return new ResponseEntity<Object>(carService.findId(id), HttpStatus.OK);
	        } catch (ResourceNotFoundException e) {
	            System.out.print(e);
	            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
	            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping()
	    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
	        System.out.println("update Car " + car);
	        return new ResponseEntity<Car>(carService.updateCar(car), HttpStatus.OK);

	    }

	    @DeleteMapping()
	    public ResponseEntity<String> deleteCar(@RequestParam(name="id") long id) {
	        System.out.println("update Car " + id);
	        carService.deleteCar(id);
	        return new ResponseEntity<String>("Car deleted Successfuly!", HttpStatus.OK);
	    }


}
