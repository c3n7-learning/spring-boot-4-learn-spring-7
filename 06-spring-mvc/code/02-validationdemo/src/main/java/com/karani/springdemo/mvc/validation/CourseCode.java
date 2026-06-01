package com.karani.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";


    // define default error message
    public String message() default "must start with LUV";

    // define default groups
    // where you group related validation constraints together
    public Class<?>[] groups() default {};

    // define default payloads
    // where you provide additional information about the validation error
    // (severity level, error code, etc.)
    public Class<? extends Payload>[] payload() default {};
}
