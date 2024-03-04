package com.spring.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="vehicle", schema="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vehicle_type")
	private String vehicleType;

	@Column(name = "vehicle_model")
	private String vehicleModel;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;

	@Column(name = "interior_id")
	private Long interiorId;

	@Column(name = "exterior_id")
	private Long exteriorId;

	@Column(name = "color")
	private String color;

	@Column(name = "color_style")
	private String colorStyle;

	@Column(name = "engine_number")
	private Long engineNumber;
	
	@Column(name = "tranmission_number")
	private Long tranmissionNumber;

}