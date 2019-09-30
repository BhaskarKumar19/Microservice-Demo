package com.hmsi.mdhonda.apntmntReqService.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmsi.mdhonda.apntmntReqService.dto.AppointmentDto;
import com.hmsi.mdhonda.apntmntReqService.dto.CustomerDto;
import com.hmsi.mdhonda.apntmntReqService.dto.VehicleDto;
import com.hmsi.mdhonda.apntmntReqService.entities.AppointmentRequest;
import com.hmsi.mdhonda.apntmntReqService.entities.Customer;
import com.hmsi.mdhonda.apntmntReqService.entities.Vehicle;
import com.hmsi.mdhonda.apntmntReqService.service.ApntmntService;

@RestController
@RequestMapping("/apntmnt-req-api")
@EnableEurekaClient
public class ApntmntReqController {

	@Autowired
	private ApntmntService apntmntService;

	@GetMapping(path = "/apntmnts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentDto> getAllAppointments() {
		return apntmntService.getAllAppointments();
	}

	@PutMapping(path = "/apntmnts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentDto> addAppointments(@RequestBody List<AppointmentDto> appointmentList) {
		if (appointmentList == null || appointmentList.isEmpty()) {
			appointmentList = new ArrayList();
			VehicleDto v = new VehicleDto(623, "Shine", "motorcycle", "red");
			CustomerDto c = new CustomerDto(223, "Ravi", "Anand", "Delhi", "7834945727", "ra@gmail.com", "854301");
			AppointmentDto a = new AppointmentDto(1, v, c, "default comment", 1234567L, 123455L, new Date(),
					Long.toString(new Date().getTime()));
			appointmentList.add(a);
		}
		return apntmntService.addAppointments(appointmentList);
	}

	@DeleteMapping(path = "/apntmnts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentDto> deleteCatalogs(@RequestBody List<AppointmentDto> catalogs) {
		return null;// quoteService.deleteCatalogs(catalogs);
	}

}
