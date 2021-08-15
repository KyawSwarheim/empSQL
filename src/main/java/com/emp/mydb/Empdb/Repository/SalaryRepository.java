package com.emp.mydb.Empdb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.emp.mydb.Empdb.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long>{
}
