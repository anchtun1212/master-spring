package com.anchtun.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.anchtun.annotation.FieldsValueMatch;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

	private String field;
	private String fieldMatch;

	@Override
	public void initialize(FieldsValueMatch constraintAnnotation) {
		this.field = constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
		Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
		if (Objects.nonNull(fieldValue)) {
			return fieldValue.equals(fieldMatchValue);
		} else {
			return Objects.isNull(fieldMatchValue);
		}
	}

}
