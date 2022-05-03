package com.anchtun.aspect;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2) // because we have many aspects this aspect will be executed second
public class LoggerAspect {

	private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

	// @Around (has the opportunity to do work both before and after)
	@Around("execution(* com.anchtun.service.aop.*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature().toString() + " method execution start");
		Instant start = Instant.now();
		logger.info("Start method " + joinPoint.getSignature().getName());
		joinPoint.proceed();
		Instant end = Instant.now();
		logger.info("End method " + joinPoint.getSignature().getName());
		long timeElapsed = Duration.between(start, end).toMillis();
		System.out.println("Time took to execute the method " + joinPoint.getSignature() + ": " + timeElapsed);
		logger.info(joinPoint.getSignature().toString() + " method execution end");
	}

	// will be run if the matched method execution exits by throwing an exception
	@AfterThrowing(value = "execution(* com.anchtun.service.aop.*.*(..))", throwing = "exc")
	public void logException(JoinPoint joinPoint, Exception exc) {
		logger.info("An exception occured with the help of @AfterThrowing: " + exc.getMessage());
	}

	// will be executed when we call this method only: VehicleServices2.pressBrake
	// will be run if the matched method execution completes normally
	@AfterReturning(value = "execution(* com.anchtun.service.aop.VehicleServices2.pressBrake(..))", returning = "retValue")
	public void logStatus(JoinPoint joinPoint, Object retValue) {
		logger.info("The method: " + joinPoint.getSignature() + " has been run successfully with this status: " + retValue);
	}

}
