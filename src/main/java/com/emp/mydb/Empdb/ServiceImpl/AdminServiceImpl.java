package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.Repository.AdminRepository;
import com.emp.mydb.Empdb.Service.AdminService;
import com.emp.mydb.Empdb.entity.Admin;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public Admin findId(long adminId) {
		return adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "Id", adminId));
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Admin exitingAdmin = findId(admin.getAdminId());
		exitingAdmin.setName(admin.getName());
		exitingAdmin.setPhone(admin.getPhone());
		exitingAdmin.setEmail(admin.getEmail());
		exitingAdmin.setGender(admin.getGender());
		exitingAdmin.setRole(admin.getRole());
		exitingAdmin.setAction(admin.getAction());
		adminRepository.save(exitingAdmin);
		return exitingAdmin;
	}

	@Override
	public void deleteAdmin(long id) {
		adminRepository.deleteById(id);
		
	}

}
