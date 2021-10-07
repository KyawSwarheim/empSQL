package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Daily;


@Service
public interface DailyService {
	
	Daily saveDaily(Daily daily);
	
	List<Daily> getAllDaily();

	Daily findId(long dailyId);
	
	Daily updateDaily(Daily daily);
	
	void deleteDaily(long id);

}
