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

import com.emp.mydb.Empdb.Service.MaintenanceService;
import com.emp.mydb.Empdb.entity.Maintenance;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/maintenance")
@CrossOrigin(origins = "*")
public class MaintenanceController {
	
	@Autowired
	MaintenanceService maintenanceService;
	
	@PostMapping()
    public ResponseEntity<Maintenance> saveMaintenance(@RequestBody Maintenance maintenance) {
        System.out.println("post controller " + maintenance);
        return new ResponseEntity<Maintenance>(maintenanceService.saveMaintenance(maintenance), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Maintenance>> getAllMaintenance() {
        System.out.println("get Maintenance controller ");
        return new ResponseEntity<List<Maintenance>>(maintenanceService.getAllMaintenance(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getMaintenanceById(@PathVariable("id") long id) {
        try {
            System.out.println("get by id Maintenance " + id);
            return new ResponseEntity<Object>(maintenanceService.findId(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            System.out.print(e);
            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Maintenance> updateMaintenance(@RequestBody Maintenance maintenance) {
        System.out.println("update Maintenance " + maintenance);
        return new ResponseEntity<Maintenance>(maintenanceService.updateMaintenance(maintenance), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteMaintenance(@RequestParam(name="id") long id) {
        System.out.println("update Maintenance " + id);
        maintenanceService.deleteMaintenance(id);
        return new ResponseEntity<String>("Maintenance deleted Successfuly!", HttpStatus.OK);
    }

}
