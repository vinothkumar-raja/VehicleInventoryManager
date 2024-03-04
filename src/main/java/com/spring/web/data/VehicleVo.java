package com.spring.web.data;

import lombok.Data;

@Data
public class VehicleVo {
	
	private Long id;
	private String vehicleType;
	private String vehicleModel;
	private String vehicleNumber;
	private Long interiorId;
	private Long exteriorId;
	private String color;
	private String colorStyle;
	private Long engineNumber;
	private Long tranmissionNumber;

}
