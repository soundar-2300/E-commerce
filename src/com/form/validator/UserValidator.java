package com.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.form.viewBean.UserBean;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {

		return UserBean.class.isAssignableFrom(paramClass);
	}

	@Override
	public void validate(Object result, Errors error) {

		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", "error.firstName", "FirstName is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastName", "error.lastName", "Atleast Enter Initials");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "error.password", "Enter valid Password");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "confirmPassword", "error.confirmPassword","Must match Password");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "error.email", "Enter the valid email id");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "mobile", "error.mobile", "Mobile must have 10 numbers");
        ValidationUtils.rejectIfEmpty( error,"email","error.email", "Already Registered");
	}

}
