package com.anchtun.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

	@Around("execution(* com.anchtun..*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info(joinPoint.getSignature().toString() + " method execution start");
		Instant start = Instant.now();
		Object obj = joinPoint.proceed();
		Instant end = Instant.now();
		long timeElapsed = Duration.between(start, end).toMillis();
		log.info("Time took to execute the method " + joinPoint.getSignature() + ": " + timeElapsed);
		log.info(joinPoint.getSignature().toString() + " method execution end");
		return obj;
	}
	
	@AfterThrowing(value = "execution(* com.anchtun..*.*(..))", throwing = "exc")
	public void logException(JoinPoint joinPoint, Exception exc) {
		log.error("An exception occured with the help of @AfterThrowing: " + exc.getMessage());
	}
	
}
