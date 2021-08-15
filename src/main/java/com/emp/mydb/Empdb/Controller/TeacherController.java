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
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
		return new ResponseEntity<Teacher>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
	}
	@GetMapping()
	public List<Teacher> getAllTeachers(){
		return teacherService.getAllTeachers();
	}
	@GetMapping("{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable("id")long TeacherId){
		try {
			return new ResponseEntity<Teacher>(teacherService.getTeacherById(TeacherId), HttpStatus.OK);
	}catch (ResourceNotFoundException e) {
		System.out.print(e);
		DefaultReponse defaultReponse = new DefaultReponse(e.getMessage());
		return new ResponseEntity(defaultReponse,HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping()
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
		return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher), HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("id")long id){
		//delete employee from DB
		teacherService.deleteTeacher(id);
		return new ResponseEntity<String>("Teacher deleted Successfuly!", HttpStatus.OK);
	}
	@PostMapping("/add")
	public Teacher addTeacher(@RequestBody TeacherRequest teacherRequest) {
		return teacherService.addTeacher(teacherRequest);
		
	}

}
