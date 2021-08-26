package com.emp.mydb.Empdb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.emp.mydb.Empdb.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	@Query(value = "Select * from Role r where r.rolename like %:rolename%",nativeQuery = true)
	List<Role> findByNameLike(@Param("rolename") String name);
	
	@Query(value = "Select * from Role r where r.rolename = ?1",nativeQuery = true)
	Role findByName(@Param("rolename") String name);


}
