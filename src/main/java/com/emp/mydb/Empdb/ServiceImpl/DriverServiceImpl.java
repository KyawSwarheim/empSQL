package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.Repository.DriverRepository;
import com.emp.mydb.Empdb.Service.DriverService;
import com.emp.mydb.Empdb.entity.Driver;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	DriverRepository driverRepository;

	@Override
	public Driver saveDriver(Driver driver) {
		return driverRepository.save(driver);
	}

	@Override
	public List<Driver> getAllDriver() {
		return driverRepository.findAll();
	}

	@Override
	public Driver findId(long driverId) {
		return driverRepository.findById(driverId)
				.orElseThrow(() -> new ResourceNotFoundException("Driver", "Id", driverId));
	}

	@Override
	public Driver updateDriver(Driver driver) {
		Driver exitingDriver = findId(driver.getDriverId());
		exitingDriver.setName(driver.getName());
		exitingDriver.setPhone(driver.getPhone());
		exitingDriver.setNrc(driver.getNrc());
		exitingDriver.setGender(driver.getGender());
		exitingDriver.setLicense(driver.getLicense());
		exitingDriver.setAddress(driver.getAddress());
		exitingDriver.setAction(driver.getAction());
		driverRepository.save(exitingDriver);
		return exitingDriver;
	}

	@Override
	public void deleteDriver(long id) {
		driverRepository.deleteById(id);
		
	}

}
