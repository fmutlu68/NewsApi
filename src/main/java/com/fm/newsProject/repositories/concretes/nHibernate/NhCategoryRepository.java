package com.fm.newsProject.repositories.concretes.nHibernate;

import com.fm.newsProject.core.repository.nHibernate.NhModelRepositoryBase;
import com.fm.newsProject.repositories.abstracts.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.fm.newsProject.models.concretes.Category;
import com.fm.newsProject.repositories.abstracts.jpa.JpaCategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class NhCategoryRepository extends NhModelRepositoryBase<Category, JpaCategoryRepository> implements CategoryRepository {

    @Autowired
    public NhCategoryRepository(JpaCategoryRepository jpaRepository) {
        super(jpaRepository);
    }
}
