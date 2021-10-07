package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.Repository.RolesRepository;
import com.emp.mydb.Empdb.Service.RolesService;
import com.emp.mydb.Empdb.entity.Roles;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class RolesServiceImpl implements RolesService{
	
	@Autowired
	RolesRepository rolesRepository;

	@Override
	public Roles saveRoles(Roles roles) {
		return rolesRepository.save(roles);
	}

	@Override
	public List<Roles> getAllRoles() {
		return rolesRepository.findAll();
	}

	@Override
	public Roles findId(long rolesId) {
		return rolesRepository.findById(rolesId)
				.orElseThrow(() -> new ResourceNotFoundException("Roles", "Id", rolesId));
	}

	@Override
	public Roles updateRoles(Roles roles) {
		Roles exitingRoles = findId(roles.getRoleId());
		exitingRoles.setName(roles.getName());
		exitingRoles.setLevel(roles.getLevel());
		exitingRoles.setAction(roles.getAction());
		rolesRepository.save(exitingRoles);
		return exitingRoles;
	}

	@Override
	public void deleteRoles(long id) {
		rolesRepository.deleteById(id);
		
	}

}
