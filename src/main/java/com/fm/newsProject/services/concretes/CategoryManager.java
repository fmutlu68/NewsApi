package com.fm.newsProject.services.concretes;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.core.utilities.results.SuccessDataResult;
import com.fm.newsProject.core.utilities.results.SuccessResult;
import com.fm.newsProject.models.concretes.Category;
import com.fm.newsProject.repositories.concretes.nHibernate.NhCategoryRepository;
import com.fm.newsProject.services.abstracts.CategoryService;
import com.fm.newsProject.services.businessAnnotations.Validate;
import com.fm.newsProject.services.validationRules.concretes.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private NhCategoryRepository categoryRepository;

    @Autowired
    public CategoryManager(NhCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<List<Category>>(categoryRepository.getAll(), "Listeleme Başarılı");
    }

    @Override
    @Validate(currentValidation = Validations.CATEGORYVALIDATOR)
    public Result add(Category category) {
        categoryRepository.add(category);
        return new SuccessResult("Kategori Ekleme İşlemi Başarılı.");
    }

    @Override
    @Validate(currentValidation = Validations.CATEGORYVALIDATOR)
    public Result update(Category category) {
        categoryRepository.update(category);
        return new SuccessResult("Kategori Güncelleme Başarılı.");
    }

    @Override
    public Result delete(Category category) {
        categoryRepository.delete(category);
        return new SuccessResult("Kategori Silme İşlemi Başarılı");
    }

    @Override
    public DataResult<Category> getById(int id) {
        return new SuccessDataResult<Category>(categoryRepository.get(category -> category.getId() == id, "Kategori"));
    }
}
