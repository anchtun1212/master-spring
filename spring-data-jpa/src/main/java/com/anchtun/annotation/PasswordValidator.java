package com.anchtun.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.anchtun.validator.PasswordStrengthValidator;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface PasswordValidator {

	String message() default "Please choose a strong password";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
