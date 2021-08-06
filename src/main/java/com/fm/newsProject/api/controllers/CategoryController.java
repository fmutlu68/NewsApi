package com.fm.newsProject.api.controllers;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.models.concretes.Category;
import com.fm.newsProject.services.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public DataResult<List<Category>> getAll(){
        return this.categoryService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Category category){
        return this.categoryService.add(category);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Category category){
        return this.categoryService.update(category);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Category category){
        return this.categoryService.delete(category);
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<Category> getById(int id){
        return this.categoryService.getById(id);
    }
}
