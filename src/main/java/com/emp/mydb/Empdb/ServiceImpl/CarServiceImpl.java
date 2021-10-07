package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.Repository.CarRepository;
import com.emp.mydb.Empdb.Service.CarService;
import com.emp.mydb.Empdb.entity.Car;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	CarRepository carRepository;

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}

	@Override
	public Car findId(long carId) {
		return carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Car", "Id", carId));
	}

	@Override
	public Car updateCar(Car car) {
		Car exitingCar = findId(car.getCarId());
		exitingCar.setCarNo(car.getCarNo());
		exitingCar.setBrand(car.getBrand());
		exitingCar.setName(car.getName());
		exitingCar.setModelYear(car.getModelYear());
		exitingCar.setStartDate(car.getStartDate());
		exitingCar.setColor(car.getColor());
		exitingCar.setTaxiNumber(car.getTaxiNumber());
		exitingCar.setLicenseMonth(car.getLicenseMonth());
		exitingCar.setDaily(car.getDaily());
		exitingCar.setAction(car.getAction());		
		carRepository.save(exitingCar);
		return exitingCar;
	}

	@Override
	public void deleteCar(long id) {
		carRepository.deleteById(id);
		
	}

}
