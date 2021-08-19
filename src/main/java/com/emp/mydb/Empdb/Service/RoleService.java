package com.emp.mydb.Empdb.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.entity.Role;

@Service
public interface RoleService {
	
	Role saveRole(Role role);
	
	List<Role> getAllRoles();

	Role findById(long roleId);
	
	Role updateRole(Role role);
	
	void deleteRole(long id);


}
