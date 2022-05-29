package com.anchtun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions across 
 * the whole application in one global handling component. It can be viewed as an interceptor of exceptions 
 * thrown by methods annotated with @RequestMapping and similar.
 */

@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionController {
	
	/**
	 * Need to write the logic of each exception type
	 */
	
	@ExceptionHandler(NullPointerException.class)
	ModelAndView nullPointerExceptionHandler(NullPointerException ex) {
		ModelAndView errorPage = new ModelAndView();
		errorPage.setViewName("error");
		errorPage.addObject("errMsg", ex.getMessage());
		return errorPage;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	ModelAndView illegalArgumentExceptionHandler(IllegalArgumentException ex) {
		ModelAndView errorPage = new ModelAndView();
		errorPage.setViewName("error");
		errorPage.addObject("errMsg", ex.getMessage());
		return errorPage;
	}

}
