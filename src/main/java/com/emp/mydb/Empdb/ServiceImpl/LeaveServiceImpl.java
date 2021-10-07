package com.emp.mydb.Empdb.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mydb.Empdb.Repository.LeaveRepository;
import com.emp.mydb.Empdb.Service.LeaveService;
import com.emp.mydb.Empdb.entity.Leave;
import com.emp.mydb.Empdb.exception.ResourceNotFoundException;

@Service
public class LeaveServiceImpl implements LeaveService{
	
	@Autowired
	LeaveRepository leaveRepository;

	@Override
	public Leave saveLeave(Leave leave) {
		return leaveRepository.save(leave);
	}

	@Override
	public List<Leave> getAllLeave() {
		return leaveRepository.findAll();
	}

	@Override
	public Leave findId(long leaveId) {
		return leaveRepository.findById(leaveId)
				.orElseThrow(() -> new ResourceNotFoundException("Leave", "Id", leaveId));
	}

	@Override
	public Leave updateLeave(Leave leave) {
		Leave exitingLeave = findId(leave.getLeaveId());
		exitingLeave.setDriver(leave.getDriver());
		exitingLeave.setCar(leave.getCar());
		exitingLeave.setStartDate(leave.getStartDate());
		exitingLeave.setEndDate(leave.getEndDate());
		exitingLeave.setDays(leave.getDays());
		exitingLeave.setReason(leave.getReason());
		leaveRepository.save(exitingLeave);
		return exitingLeave;
	}

	@Override
	public void deleteLeave(long id) {
		leaveRepository.deleteById(id);
		
	}

}
