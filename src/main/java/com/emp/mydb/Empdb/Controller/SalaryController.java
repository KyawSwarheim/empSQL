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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.emp.mydb.Empdb.Service.SalaryService;
import com.emp.mydb.Empdb.entity.Salary;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/salarys")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @PostMapping()
    public ResponseEntity<Salary> saveSalary(@RequestBody Salary salary) {
        System.out.println("post controller " + salary);
        return new ResponseEntity<Salary>(salaryService.saveSalary(salary), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Salary>> getAllSalaries() {
        System.out.println("get salary controller ");
        return new ResponseEntity<List<Salary>>(salaryService.getAllSalarys(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getSalaryById(@PathVariable("id") long id) {
        try {
            System.out.println("get by id salary " + id);
            return new ResponseEntity<Object>(salaryService.findId(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            System.out.print(e);
            DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
            return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Salary> updateSalary(@RequestBody Salary salary) {
        System.out.println("update salary " + salary);
        return new ResponseEntity<Salary>(salaryService.updateSalary(salary), HttpStatus.OK);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteSalary(@RequestParam(name="id") long id) {
        System.out.println("update salary " + id);
        salaryService.deleteSalary(id);
        return new ResponseEntity<String>("Salary deleted Successfuly!", HttpStatus.OK);
    }

}
