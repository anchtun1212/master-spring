package com.anchtun.beans.explicit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anchtun.service.explicit.VehicleServices3;

@Component("vehicle3Bean")
public class Vehicle3 {

	private String name = "Mercedes";
	private final VehicleServices3 vehicleServices;

	@Autowired
	public Vehicle3(VehicleServices3 vehicleServices) {
		System.out.println("Vehicle bean created by Spring");
		this.vehicleServices = vehicleServices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VehicleServices3 getVehicleServices() {
		return vehicleServices;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
