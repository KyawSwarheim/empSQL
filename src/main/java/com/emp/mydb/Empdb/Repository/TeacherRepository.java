package com.emp.mydb.Empdb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.emp.mydb.Empdb.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	@Query(value = "Select * from Teacher t where t.name like %:name%",nativeQuery = true)
	List<Teacher> findByName(@Param("name") String name);
	
}
