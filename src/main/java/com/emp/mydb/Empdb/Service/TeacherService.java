package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Teacher;

@Service
public interface TeacherService {
	
	Teacher saveTeacher(Teacher teacher);
	
	List<Teacher> getAllTeachers();

	Teacher findById(long teacherId);
	
	Teacher getTeacherById(long id);
	
	Teacher updateTeacher(Teacher teacher);
	
	void deleteTeacher(long id);

}
