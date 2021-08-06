package com.fm.newsProject.repositories.concretes.nHibernate;

import com.fm.newsProject.core.repository.nHibernate.NhModelRepositoryBase;
import com.fm.newsProject.models.concretes.News;
import com.fm.newsProject.repositories.abstracts.jpa.JpaNewsRepository;
import com.fm.newsProject.repositories.abstracts.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NhNewsRepository extends NhModelRepositoryBase<News, JpaNewsRepository> implements NewsRepository {

    @Autowired
    public NhNewsRepository(JpaNewsRepository jpaRepository) {
        super(jpaRepository);
    }
}
