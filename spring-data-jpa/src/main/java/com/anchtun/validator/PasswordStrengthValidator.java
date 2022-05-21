package com.anchtun.validator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.anchtun.annotation.PasswordValidator;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

	List<String> weakPasswords;

	@Override
	public void initialize(PasswordValidator passwordValidator) {
		weakPasswords = Arrays.asList("12345", "123456", "1234567", "12345678", "pass", "password", "admin", "querty",
				"azerty");
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		return Objects.nonNull(password) && !weakPasswords.contains(password);
	}

}
