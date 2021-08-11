package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.Repository.TeacherRepository;
import com.emp.mydb.Empdb.Service.TeacherService;
import com.emp.mydb.Empdb.entity.Role;
import com.emp.mydb.Empdb.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findById(long teacherId) {
		return teacherRepository.getById(teacherId);
	}

	@Override
	public Teacher getTeacherById(long id) {
		return teacherRepository.findById(id);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Teacher exitingTeacher = getTeacherById(teacher.getId());
		exitingTeacher.setName(teacher.getName());
		exitingTeacher.setSubject(teacher.getSubject());
		exitingTeacher.setDevelopment(teacher.getDevelopment());
		
		teacherRepository.save(exitingTeacher);
		return exitingTeacher;
	}

	@Override
	public void deleteTeacher(long id) {
		teacherRepository.deleteById(id);
		
	}

}
