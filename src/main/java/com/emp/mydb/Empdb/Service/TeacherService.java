package com.emp.mydb.Empdb.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.entity.Teacher;
import com.emp.mydb.Empdb.request.TeacherRequest;

@Service
public interface TeacherService {
	
	List<Teacher> getAllTeachers();

	Teacher findById(long teacherId);
	
	List<Teacher> findByName(String name);
	
	Teacher updateTeacher(TeacherRequest teacherRequest);
	
	void deleteTeacher(long id);
	
	Teacher addTeacher(TeacherRequest teacherRequest);

}
