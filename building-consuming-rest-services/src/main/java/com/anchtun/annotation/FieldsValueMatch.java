package com.anchtun.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.anchtun.validator.FieldsValueMatchValidator;
/**
 * To check if two fields value match, like: email and confirm email and password and confirm password
 *
 */
@Documented
@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ TYPE })
@Retention(RUNTIME)
public @interface FieldsValueMatch {

	String message() default "Fields values not match";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	// I will try to validate the values of two fields thats why we add the lines bellow
	// otherwise if you will validate only one field you can keep them
	String field();
	
	String fieldMatch();
	
	@Target({ TYPE })
	@Retention(RUNTIME)
	@interface List {
		FieldsValueMatch[] value();
	}
}
