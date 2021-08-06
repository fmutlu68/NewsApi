package com.fm.newsProject.services.validationRules.abstracts;

import com.fm.newsProject.core.utilities.errors.ValidationError;

public interface MainValidator<T> {
	ValidationError validate(T entity);
	boolean support(Class<?> clasz);
}	
