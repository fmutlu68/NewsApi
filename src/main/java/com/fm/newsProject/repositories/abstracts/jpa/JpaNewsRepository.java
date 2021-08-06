package com.fm.newsProject.repositories.abstracts.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fm.newsProject.models.concretes.News;
import org.springframework.stereotype.Component;

@Component
public interface JpaNewsRepository extends JpaRepository<News, Integer>{

}
