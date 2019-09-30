package com.hmsi.mdhonda.apntmntReqService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmsi.mdhonda.apntmntReqService.dto.AppointmentDto;
import com.hmsi.mdhonda.apntmntReqService.entities.AppointmentRequest;
import com.hmsi.mdhonda.apntmntReqService.mapper.ApntmntMapper;
import com.hmsi.mdhonda.apntmntReqService.repo.ApntmntRepository;

@Service
public class ApntmntService {
	
	@Autowired
	private ApntmntRepository apntmntRepository;
	@Autowired
	private ApntmntMapper apntmntMapper;
	
	public List<AppointmentDto> getAllAppointments(){
		List<AppointmentRequest> appointmentList = apntmntRepository.findAll();
		return apntmntMapper.apntmntEntityToDto(appointmentList);
	}

	@Transactional
	public List<AppointmentDto> addAppointments(List<AppointmentDto> appointmentDto) {
		List<AppointmentRequest> appointmentList = apntmntMapper.apntmntDtoToEntity(appointmentDto);
		apntmntRepository.saveAll(appointmentList);
		return getAllAppointments();
	}
	
	
}
