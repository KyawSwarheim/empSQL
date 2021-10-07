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

import com.emp.mydb.Empdb.Service.LeaveService;
import com.emp.mydb.Empdb.entity.Leave;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/leave")
@CrossOrigin(origins = "*")
public class LeaveController {

	@Autowired
	LeaveService leaveService;
	
	@PostMapping()
    public ResponseEntity<Leave> saveLeave(@RequestBody Leave leave) {
        System.out.println("post controller " + leave);
        return new ResponseEntity<Leave>(leaveService.saveLeave(leave), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Leave>> getAllLeave() {
        System.out.println("get Leave controller ");
        return new ResponseEntity<List<Leave>>(leaveService.getAllLeave(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getLeaveById(@PathVariable("id") long id) {
        try {
            System.out.println("get by id Leave " + id);
            return new ResponseEntity<Object>(leaveService.findId(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            System.out.print(e);
            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Leave> updateLeave(@RequestBody Leave leave) {
        System.out.println("update Leave " + leave);
        return new ResponseEntity<Leave>(leaveService.updateLeave(leave), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteLeave(@RequestParam(name="id") long id) {
        System.out.println("update Leave " + id);
        leaveService.deleteLeave(id);
        return new ResponseEntity<String>("Leave deleted Successfuly!", HttpStatus.OK);
    }
}
