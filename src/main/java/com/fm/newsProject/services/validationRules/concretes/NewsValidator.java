package com.fm.newsProject.services.validationRules.concretes;


import com.fm.newsProject.core.utilities.errors.ValidationError;
import com.fm.newsProject.models.concretes.News;
import com.fm.newsProject.services.utilities.errors.ErrorMessages;
import com.fm.newsProject.services.validationRules.abstracts.MainValidator;

public class NewsValidator implements MainValidator<News> {

	@Override
	public boolean support(Class<?> clasz) {
		return News.class.equals(clasz);
	}

	@Override
	public ValidationError validate(News entity) {
		var validationTitle = validateTitle(entity.getTitle());
		if (validationTitle != null) {
			return validationTitle;
		}
		return null;
	}
	
	private ValidationError validateTitle(String title) {
		if (title == null){
			return new ValidationError(ErrorMessages.getNewsTitleNullError(), "haber başlığı");
		}else if (title.length() <= 5) {
			return new ValidationError(ErrorMessages.getNewsTitleLengthSmallerThan6(), "haber başlığı");
		}
		return null;
	}
}
