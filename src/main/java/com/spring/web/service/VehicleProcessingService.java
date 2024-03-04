package com.spring.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.data.VehicleVo;
import com.spring.web.entity.Vehicle;
import com.spring.web.exception.DataException;
import com.spring.web.repository.VehicleRepository;

@Service
public class VehicleProcessingService {
	
	@Autowired
	private VehicleRepository repository;

	public List<VehicleVo> getAllVehicleInformation(String vehicleType) {
		return convertEntityToVo(repository.findByType(vehicleType));
	}
	

	public VehicleVo getVehicleInformation(Long id) {
		if (repository.findById(id).isPresent()) {
			return convertEntityToVo(repository.findById(id).get());

		} else {
			throw new DataException("No Data found for this Vehicle Id:" + id);
		}
	}

	private List<VehicleVo> convertEntityToVo(List<Vehicle> vehicleList) {
		List<VehicleVo> vehicleVoList = new ArrayList<>();
		
		for(Vehicle vehicle : vehicleList) {
			vehicleVoList.add(convertEntityToVo(vehicle));
		}

		return vehicleVoList;
	}

	private VehicleVo convertEntityToVo(Vehicle vehicle) {
		VehicleVo vehicleVo = new VehicleVo();
		vehicleVo.setColor(vehicle.getColor());
		vehicleVo.setColorStyle(vehicle.getColorStyle());
		vehicleVo.setEngineNumber(vehicle.getEngineNumber());
		vehicleVo.setExteriorId(vehicle.getExteriorId());
		vehicleVo.setInteriorId(vehicle.getInteriorId());
		vehicleVo.setId(vehicle.getId());
		vehicleVo.setTranmissionNumber(vehicle.getTranmissionNumber());
		vehicleVo.setVehicleModel(vehicle.getVehicleModel());
		vehicleVo.setVehicleType(vehicle.getVehicleType());
		return vehicleVo;
	}


	public String save(VehicleVo data) {
		Vehicle vehicle = new Vehicle();
		vehicle.setColor(data.getColor());
		vehicle.setColorStyle(data.getColorStyle());
		vehicle.setEngineNumber(data.getEngineNumber());
		vehicle.setExteriorId(data.getExteriorId());
		vehicle.setInteriorId(data.getInteriorId());
		vehicle.setId(data.getId());
		vehicle.setTranmissionNumber(data.getTranmissionNumber());
		vehicle.setVehicleModel(data.getVehicleModel());
		vehicle.setVehicleType(data.getVehicleType());
		repository.save(vehicle);	
		
		return "Data Save successfully!!";
	}

}
