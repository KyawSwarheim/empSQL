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
import com.emp.mydb.Empdb.Service.TeacherService;
import com.emp.mydb.Empdb.entity.Teacher;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.request.TeacherRequest;
import com.emp.mydb.Empdb.response.DefaultReponse;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@PostMapping()
	public ResponseEntity<Teacher> addTeacher(@RequestBody TeacherRequest teacherRequest) {
		return new ResponseEntity<Teacher>(teacherService.addTeacher(teacherRequest), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		return new ResponseEntity<List<Teacher>>(teacherService.getAllTeachers(), HttpStatus.OK);
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<Object> getTeacherById(@PathVariable("id") long TeacherId) {
		try {
			return new ResponseEntity<Object>(teacherService.findById(TeacherId), HttpStatus.OK);
			
		} catch (ResourceNotFoundException e) {
			System.out.print(e);
			DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
			return new ResponseEntity<Object>(defaultReponse, HttpStatus.NOT_FOUND);
		}		
	}
	@GetMapping("/name")
	public ResponseEntity<List<Teacher>> getName(@RequestParam("name") String name) {
		return new ResponseEntity<List<Teacher>>(teacherService.findByName(name), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Teacher> updateTeacher(@RequestBody TeacherRequest teacherRequest) {
		return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacherRequest), HttpStatus.OK);
	}

	@DeleteMapping()
	public ResponseEntity<String> deleteTeacher(@RequestParam("id") long id) {
		teacherService.deleteTeacher(id);
		return new ResponseEntity<String>("Teacher deleted Successfuly!", HttpStatus.OK);
	}

}
