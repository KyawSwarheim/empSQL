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

import com.emp.mydb.Empdb.Service.DailyService;
import com.emp.mydb.Empdb.entity.Daily;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/daily")
@CrossOrigin(origins = "*")
public class DailyController {

	@Autowired
	DailyService dailyService;
	
	@PostMapping()
    public ResponseEntity<Daily> saveDaily(@RequestBody Daily daily) {
        System.out.println("post controller " + daily);
        return new ResponseEntity<Daily>(dailyService.saveDaily(daily), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Daily>> getAllDaily() {
        System.out.println("get Daily controller ");
        return new ResponseEntity<List<Daily>>(dailyService.getAllDaily(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getDailyById(@PathVariable("id") long id) {
        try {
            System.out.println("get by id Daily " + id);
            return new ResponseEntity<Object>(dailyService.findId(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            System.out.print(e);
            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Daily> updateDaily(@RequestBody Daily daily) {
        System.out.println("update Daily " + daily);
        return new ResponseEntity<Daily>(dailyService.updateDaily(daily), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteDaily(@RequestParam(name="id") long id) {
        System.out.println("update Daily " + id);
        dailyService.deleteDaily(id);
        return new ResponseEntity<String>("Daily deleted Successfuly!", HttpStatus.OK);
    }
}
