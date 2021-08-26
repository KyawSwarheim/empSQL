package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.SalaryRepository;
import com.emp.mydb.Empdb.Repository.TeacherRepository;
import com.emp.mydb.Empdb.Service.TeacherService;
import com.emp.mydb.Empdb.entity.Salary;
import com.emp.mydb.Empdb.entity.Teacher;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;
import com.emp.mydb.Empdb.request.TeacherRequest;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	SalaryRepository salaryRepository;

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findById(long teacherId) {
		return teacherRepository.findById(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher", "Id", teacherId));
	}
	
	@Override
	public Teacher addTeacher(TeacherRequest teacherRequest) {
		Teacher teacher = new Teacher();
		Salary salary = salaryRepository.findById(teacherRequest.getSalaryId());
		teacher.setName(teacherRequest.getName());
		teacher.setSubject(teacherRequest.getSubject());
		teacher.setDevelopment(teacherRequest.getDevelopment());
		teacher.setSalary(salary);
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher updateTeacher(TeacherRequest teacherRequest) {
		Teacher exitingTeacher = findById(teacherRequest.getId());
		exitingTeacher.setName(teacherRequest.getName());
		exitingTeacher.setSubject(teacherRequest.getSubject());
		exitingTeacher.setDevelopment(teacherRequest.getDevelopment());
		teacherRepository.save(exitingTeacher);
		return exitingTeacher;
	}

	@Override
	public void deleteTeacher(long id) {
		teacherRepository.deleteById(id);

	}

	@Override
	public List<Teacher> findByName(String name) {
		return teacherRepository.findByName(name);
	}

}
