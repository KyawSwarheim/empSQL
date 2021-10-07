package com.emp.mydb.Empdb.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.entity.Admin;
@Service
public interface AdminService {
	
	Admin saveAdmin(Admin admin);
	
	List<Admin> getAllAdmin();

	Admin findId(long adminId);
	
	Admin updateAdmin(Admin admin);
	
	void deleteAdmin(long id);

}
