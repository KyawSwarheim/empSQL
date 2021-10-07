package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Driver;


@Service
public interface DriverService {
	
	Driver saveDriver(Driver driver);
	
	List<Driver> getAllDriver();

	Driver findId(long driverId);
	
	Driver updateDriver(Driver driver);
	
	void deleteDriver(long id);

}
