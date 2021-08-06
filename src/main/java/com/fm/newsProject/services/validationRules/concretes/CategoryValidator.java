package com.fm.newsProject.services.validationRules.concretes;

import com.fm.newsProject.core.utilities.errors.ValidationError;
import com.fm.newsProject.models.concretes.Category;
import com.fm.newsProject.services.utilities.errors.ErrorMessages;
import com.fm.newsProject.services.validationRules.abstracts.MainValidator;

public class CategoryValidator implements MainValidator<Category> {
    @Override
    public ValidationError validate(Category entity) {
        // Başka Doğrulanacak Bir Field Olmadığı İçin Direk Return yaptık.
        return validateCategoryName(entity.getCategoryName());
    }

    private ValidationError validateCategoryName(String categoryName) {
        if (categoryName == null){
            return new ValidationError(ErrorMessages.getCategoryNameNullError(), "Kategori Adı");
        }else if (categoryName.length() < 2){
            return new ValidationError(ErrorMessages.getCategoryNameLengthSmallerThan2(), "Kategori Adı");
        }
        return null;
    }

    @Override
    public boolean support(Class<?> clasz) {
        return Category.class.equals(clasz);
    }
}
