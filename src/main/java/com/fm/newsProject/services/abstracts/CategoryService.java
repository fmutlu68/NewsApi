package com.fm.newsProject.services.abstracts;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.models.concretes.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAll();
    Result add(Category category);
    Result update(Category category);
    Result delete(Category category);
    DataResult<Category> getById(int id);
}
