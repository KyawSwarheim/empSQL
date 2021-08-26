package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.RoleRepository;
import com.emp.mydb.Empdb.Service.RoleService;
import com.emp.mydb.Empdb.entity.Role;
import com.emp.mydb.Empdb.exception.AlreadyExistsException;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		if (existByName(role.getRolename())) {
			throw new AlreadyExistsException("RoleName is Already Exists");
		}
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(long roleId) {
		return roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role", "Id", roleId));
	}

	@Override
	public Role updateRole(Role role) {
		// we need t check whether employee with given id is exit in DB or not
		Role exitingRole = findById(role.getRole_id());
		exitingRole.setRolename(role.getRolename());
		roleRepository.save(exitingRole);
		return exitingRole;
	}

	@Override
	public void deleteRole(long id) {
		roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role", "Id", id));
		roleRepository.deleteById(id);
	}

	@Override
	public Role findByName(String name) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			throw new AlreadyExistsException("RoleName is NOT Exists");
		}
		return roleRepository.findByName(name);
	}

	public boolean existByName(String name) {
		return findByName(name) != null;
	}

	@Override
	public List<Role> findByNameLike(String name) {
		return roleRepository.findByNameLike(name);
	}
}
