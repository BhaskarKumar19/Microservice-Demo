package com.hmsi.mdhonda.apntmntReqService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmsi.mdhonda.apntmntReqService.entities.AppointmentRequest;


@Repository
public interface ApntmntRepository extends JpaRepository<AppointmentRequest, Integer>{

	
	
}
