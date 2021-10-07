package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Car;

@Service
public interface CarService {
	
	Car saveCar(Car car);
	
	List<Car> getAllCar();

	Car findId(long carId);
	
	Car updateCar(Car car);
	
	void deleteCar(long id);

}
