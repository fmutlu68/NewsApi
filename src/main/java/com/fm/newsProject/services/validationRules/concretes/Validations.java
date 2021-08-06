package com.fm.newsProject.services.validationRules.concretes;


import com.fm.newsProject.core.utilities.errors.EnumNotFoundError;
import com.fm.newsProject.services.validationRules.abstracts.MainValidator;
import com.fm.newsProject.services.validationRules.concretes.NewsValidator;

public enum Validations {
	NEWSVALIDATOR,
	WRITERVALIDATOR,
	CATEGORYVALIDATOR;

	public final MainValidator getValidator() {
		switch (this) {
		case NEWSVALIDATOR:
			return new NewsValidator();
		case CATEGORYVALIDATOR:
			return new CategoryValidator();
		case WRITERVALIDATOR:
			return new WriterValidator();
		default:
		    throw new EnumNotFoundError(this.name(), "Bu Doğrulama Tipi Bulunamadı.");
		}
	}
}
