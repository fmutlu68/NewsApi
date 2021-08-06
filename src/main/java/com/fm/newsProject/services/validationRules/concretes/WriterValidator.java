package com.fm.newsProject.services.validationRules.concretes;


import com.fm.newsProject.core.utilities.errors.ValidationError;
import com.fm.newsProject.models.concretes.Writer;
import com.fm.newsProject.services.utilities.errors.ErrorMessages;
import com.fm.newsProject.services.validationRules.abstracts.MainValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriterValidator implements MainValidator<Writer> {
    @Override
    public ValidationError validate(Writer entity) {
        var writerFirstNameValidation = validateFirstName(entity.getFirstName());
        if (writerFirstNameValidation != null){
            return writerFirstNameValidation;
        }
        var writerLastNameValidation = validateLastName(entity.getLastName());
        if (writerLastNameValidation != null){
            return writerLastNameValidation;
        }
        var writerEmailValidation = validateEmail(entity.getEmail());
        return writerEmailValidation;
    }

    private ValidationError validateFirstName(String firstName) {
        if (firstName == null){
            return new ValidationError(ErrorMessages.getWriterFirstNameNullError(), "Yazar Adı");
        }else if (firstName.length() <= 2){
            return new ValidationError(ErrorMessages.getWriterFirstNameLengthSmallerThan3(), "Yazar Adı");
        }
        return null;
    }

    private ValidationError validateLastName(String lastName) {
        if (lastName == null){
            return new ValidationError(ErrorMessages.getWriterLastNameNullError(), "Yazar Soyadı");
        }else if (lastName.length() <= 2){
            return new ValidationError(ErrorMessages.getWriterLastNameLengthSmallerThan3(), "Yazar Soyadı");
        }
        return null;
    }

    private ValidationError validateEmail(String email) {
        var emailRegex = "^(.+)@(.+)$";
        if (email == null){
            return new ValidationError(ErrorMessages.getWriterEmailNullError(), "Yazar E-Postası");
        }
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(email).matches()){
            return new ValidationError(ErrorMessages.getWriterEmailIsInvalidError(), "Yazar E-Postası");
        }
        return null;
    }

    @Override
    public boolean support(Class<?> clasz) {
        return Writer.class.equals(clasz);
    }
}
