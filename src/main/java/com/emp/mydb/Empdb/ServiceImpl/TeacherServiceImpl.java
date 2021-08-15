package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.SalaryRepository;
import com.emp.mydb.Empdb.Repository.TeacherRepository;
import com.emp.mydb.Empdb.Service.TeacherService;
import com.emp.mydb.Empdb.entity.Salary;
import com.emp.mydb.Empdb.entity.Teacher;
import com.emp.mydb.Empdb.request.TeacherRequest;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	SalaryRepository salaryRepository;

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
		return teacherRepository.findById(teacherId).orElseThrow();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Teacher exitingTeacher = findById(teacher.getId());
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
	public Teacher addTeacher(TeacherRequest teacherRequest) {
		Salary salary = salaryRepository.getById(teacherRequest.getSalary_id());
		Teacher teacher = new Teacher();
		teacher.setName(teacherRequest.getName());
		teacher.setSubject(teacherRequest.getSubject());
		teacher.setDevelopment(teacherRequest.getDevelopment());
		teacher.setSalary(salary);
		return teacherRepository.save(teacher);
	}

}
