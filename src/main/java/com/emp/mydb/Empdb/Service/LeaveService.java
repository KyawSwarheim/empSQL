package com.emp.mydb.Empdb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.entity.Leave;


@Service
public interface LeaveService {
	
	Leave saveLeave(Leave leave);
	
	List<Leave> getAllLeave();

	Leave findId(long leaveId);
	
	Leave updateLeave(Leave leave);
	
	void deleteLeave(long id);

}
