package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.emp.mydb.Empdb.entity.Maintenance;

@Service
public interface MaintenanceService {
	
	Maintenance saveMaintenance(Maintenance maintenance);
	
	List<Maintenance> getAllMaintenance();

	Maintenance findId(long maintenanceId);
	
	Maintenance updateMaintenance(Maintenance maintenance);
	
	void deleteMaintenance(long id);

}
