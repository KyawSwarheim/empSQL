package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Roles;


@Service
public interface RolesService {

	Roles saveRoles(Roles roles);
	
	List<Roles> getAllRoles();

	Roles findId(long rolesId);
	
	Roles updateRoles(Roles roles);
	
	void deleteRoles(long id);
}
