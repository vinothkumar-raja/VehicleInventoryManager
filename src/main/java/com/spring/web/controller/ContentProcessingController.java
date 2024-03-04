package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.data.VehicleVo;
import com.spring.web.entity.Vehicle;
import com.spring.web.exception.InvalidInputException;
import com.spring.web.service.VehicleProcessingService;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ContentProcessingController {
	
	@Autowired
	private VehicleProcessingService vehicleService;
	
	@GetMapping("/healthcheck")
	public ResponseEntity<String> checkServerStatus() {
		String strVal = "Server Available. Loaded Successfully ---- "+System.currentTimeMillis();
		log.info(strVal);
		return new ResponseEntity<>(strVal, HttpStatus.OK);
	}
	
	@GetMapping("/get/{type}/all")
	public ResponseEntity<List<VehicleVo>> getAllVehicleInformation(@PathVariable String vehicleType) {
		
		if(StringUtils.isEmpty(vehicleType)) {
			throw new InvalidInputException("Invalid Vehicle Type passed for processing!!");
		}

		return new ResponseEntity<>(vehicleService.getAllVehicleInformation(vehicleType), HttpStatus.OK);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<VehicleVo> getVehicleInformation(@PathVariable Long id) {
		
		if(id==null || id == 0) {
			throw new InvalidInputException("Invalid Vehicle Id passed for processing!!");
		}

		return new ResponseEntity<>(vehicleService.getVehicleInformation(id), HttpStatus.OK);
	}
	
	@PostMapping("/get/{id}")
	public ResponseEntity<String> save(@RequestBody VehicleVo data) {
		
		if(data==null) {
			throw new InvalidInputException("Invalid Vehicle data passed for processing!!");
		}

		return new ResponseEntity<>(vehicleService.save(data), HttpStatus.OK);
	}
	
}
