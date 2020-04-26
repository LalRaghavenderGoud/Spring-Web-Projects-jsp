package com.raghav.springweb.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

	private int min;
	private int max;

	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if (email.length() >= min && email.length() <= max && EmailValidator.getInstance(false).isValid(email)) {
			return true;
		}

		return false;
	}

}
