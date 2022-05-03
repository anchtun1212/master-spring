package com.anchtun.beans.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anchtun.service.aop.VehicleServices2;

@Component("vehicle2Bean")
public class Vehicle2 {

	private String name = "Mercedes";
	private final VehicleServices2 vehicleServices;

	@Autowired
	public Vehicle2(VehicleServices2 vehicleServices) {
		System.out.println("Vehicle bean created by Spring");
		this.vehicleServices = vehicleServices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleServices2 getVehicleServices() {
		return vehicleServices;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
