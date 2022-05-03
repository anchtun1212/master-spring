package com.anchtun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * this aspect to check if the vehicle start or no, the goal is to remove this
 * line check: if (isVehicleStarted) { in VehicleServices2 class
 *
 */
@Aspect
@Component
@Order(1) // because we have many aspects this aspect will be executed first
public class VehiculeStartCheckAspect {

	// will be executed when we call this method only: VehicleServices2.moveCar
	@Before("execution(* com.anchtun.service.aop.VehicleServices2.moveCar(..)) && args(isVehicleStarted,..)")
	public void checkVehicleStarted(JoinPoint joinPoint, boolean isVehicleStarted) throws Throwable {
		if (!isVehicleStarted) {
			throw new RuntimeException("Vehicle not started yet");
		}
	}
}
