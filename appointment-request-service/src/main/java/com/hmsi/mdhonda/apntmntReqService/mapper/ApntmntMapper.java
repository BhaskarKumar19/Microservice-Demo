package com.hmsi.mdhonda.apntmntReqService.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hmsi.mdhonda.apntmntReqService.dto.AppointmentDto;
import com.hmsi.mdhonda.apntmntReqService.dto.CustomerDto;
import com.hmsi.mdhonda.apntmntReqService.dto.VehicleDto;
import com.hmsi.mdhonda.apntmntReqService.entities.AppointmentRequest;
import com.hmsi.mdhonda.apntmntReqService.entities.Customer;
import com.hmsi.mdhonda.apntmntReqService.entities.Vehicle;

@Component
public class ApntmntMapper {

	public List<AppointmentDto> apntmntEntityToDto(List<AppointmentRequest> appointmentRequest) {
		return appointmentRequest.stream()
				.map(entity -> new AppointmentDto(entity.getId(), vehicleEntityToDto(entity.getVehicle()),
						custEntityToDto(entity.getCustomer()), entity.getComment(), entity.getRegistrationNo(),
						entity.getSerialNo(), entity.getPreferrdDate(), entity.getTime()))
				.collect(Collectors.toList());
	}

	public List<AppointmentRequest> apntmntDtoToEntity(List<AppointmentDto> appointmentDto) {
		return appointmentDto.stream()
				.map(dto -> new AppointmentRequest(dto.getId(), vehicleDtoToEntity(dto.getVehicle()),
						custDtoToEntity(dto.getCustomer()), dto.getComment(), dto.getRegistrationNo(),
						dto.getSerialNo(), dto.getPreferrdDate(), dto.getTime()))
				.collect(Collectors.toList());
	}

	public Customer custDtoToEntity(CustomerDto customerDto) {

		return new Customer(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName(),
				customerDto.getCity(), customerDto.getTel(), customerDto.getEmail(), customerDto.getPostalCode());
	}

	public Vehicle vehicleDtoToEntity(VehicleDto vehicleDto) {
		return new Vehicle(vehicleDto.getId(), vehicleDto.getModel(), vehicleDto.getVarient(), vehicleDto.getColor());
	}

	public CustomerDto custEntityToDto(Customer customer) {

		return new CustomerDto(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getCity(),
				customer.getTel(), customer.getEmail(), customer.getPostalCode());
	}

	public VehicleDto vehicleEntityToDto(Vehicle vehicle) {
		return new VehicleDto(vehicle.getId(), vehicle.getModel(), vehicle.getVarient(), vehicle.getColor());
	}

}
