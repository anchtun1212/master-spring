package com.anchtun.beans.test8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anchtun.service.VehicleServices;

@Component("vehicleBean")
public class Vehicle {

	private String name = "Mercedes";
	private final VehicleServices vehicleServices;

	@Autowired
	public Vehicle(VehicleServices vehicleServices) {
		System.out.println("Vehicle bean created by Spring");
		this.vehicleServices = vehicleServices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleServices getVehicleServices() {
		return vehicleServices;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
