package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.Repository.MaintenanceRepository;
import com.emp.mydb.Empdb.Service.MaintenanceService;
import com.emp.mydb.Empdb.entity.Maintenance;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{
	
	@Autowired
	MaintenanceRepository maintenanceRepository;

	@Override
	public Maintenance saveMaintenance(Maintenance maintenance) {
		return maintenanceRepository.save(maintenance);
	}

	@Override
	public List<Maintenance> getAllMaintenance() {
		return maintenanceRepository.findAll();
	}

	@Override
	public Maintenance findId(long maintenanceId) {
		return maintenanceRepository.findById(maintenanceId)
				.orElseThrow(() -> new ResourceNotFoundException("Maintenance", "Id", maintenanceId));
	}

	@Override
	public Maintenance updateMaintenance(Maintenance maintenance) {
		Maintenance exitingMaintenance = findId(maintenance.getMaintenanceId());
		exitingMaintenance.setCar(maintenance.getCar());
		exitingMaintenance.setShop(maintenance.getShop());
		exitingMaintenance.setStartDate(maintenance.getStartDate());
		exitingMaintenance.setEndDate(maintenance.getEndDate());
		exitingMaintenance.setDays(maintenance.getDays());
		exitingMaintenance.setTotal(maintenance.getTotal());
		maintenanceRepository.save(exitingMaintenance);
		return exitingMaintenance;
	}

	@Override
	public void deleteMaintenance(long id) {
		maintenanceRepository.deleteById(id);
		
	}

}
