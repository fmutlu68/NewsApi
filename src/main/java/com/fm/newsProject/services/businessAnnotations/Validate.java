package com.fm.newsProject.services.businessAnnotations;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fm.newsProject.services.validationRules.concretes.Validations;
import org.springframework.stereotype.Component;


@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Validate {
	public Validations currentValidation();
}
