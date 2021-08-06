package com.fm.newsProject.repositories.abstracts.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fm.newsProject.models.concretes.Category;
import org.springframework.stereotype.Component;

@Component
public interface JpaCategoryRepository extends JpaRepository<Category, Integer>{

}
