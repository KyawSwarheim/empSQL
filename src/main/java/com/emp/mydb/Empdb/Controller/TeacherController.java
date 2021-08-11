package com.emp.mydb.Empdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emp.mydb.Empdb.Service.TeacherService;
import com.emp.mydb.Empdb.entity.Teacher;

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

}
