package com.fm.newsProject.services.businessAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.fm.newsProject.core.utilities.errors.ValidationError;
import com.fm.newsProject.services.businessAnnotations.Validate;
import com.fm.newsProject.services.validationRules.abstracts.MainValidator;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
	
	@Before("execution (* com.fm.newsProject.services.concretes.*.*(..)) && @annotation(com.fm.newsProject.services.businessAnnotations.Validate)")
	public void onBefore(JoinPoint joinPoint) throws ValidationError{
		Object object = joinPoint.getArgs()[0];
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Validate validateAspect = AnnotationUtils.getAnnotation(signature.getMethod(), Validate.class);
		MainValidator validator = validateAspect.currentValidation().getValidator();
        if (validator.support(object.getClass())) {
            ValidationError validationError = validator.validate(object);
            if (validationError != null) {
                throw validationError;
            }
        }
	}
}
