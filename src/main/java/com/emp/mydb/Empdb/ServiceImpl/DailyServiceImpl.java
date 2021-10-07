package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.Repository.DailyRepository;
import com.emp.mydb.Empdb.Service.DailyService;
import com.emp.mydb.Empdb.entity.Daily;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class DailyServiceImpl implements DailyService{
	
	@Autowired
	DailyRepository dailyRepository;

	@Override
	public Daily saveDaily(Daily daily) {
		return dailyRepository.save(daily);
	}

	@Override
	public List<Daily> getAllDaily() {
		return dailyRepository.findAll();
	}

	@Override
	public Daily findId(long dailyId) {
		return dailyRepository.findById(dailyId)
				.orElseThrow(() -> new ResourceNotFoundException("Daily", "Id", dailyId));
	}

	@Override
	public Daily updateDaily(Daily daily) {
		Daily exitingDaily = findId(daily.getDailyId());
		exitingDaily.setTransactionCode(daily.getTransactionCode());
		exitingDaily.setDriver(daily.getDriver());
		exitingDaily.setCar(daily.getCar());
		exitingDaily.setStartDate(daily.getStartDate());
		exitingDaily.setEndDate(daily.getEndDate());
		exitingDaily.setDaily(daily.getDaily());
		exitingDaily.setDays(daily.getDays());
		exitingDaily.setTotal(daily.getTotal());
		exitingDaily.setPaid(daily.getPaid());
		exitingDaily.setRemain(daily.getRemain());
		exitingDaily.setRemark(daily.getRemark());
		dailyRepository.save(exitingDaily);
		return exitingDaily;
	}

	@Override
	public void deleteDaily(long id) {
		dailyRepository.deleteById(id);
		
	}

}
