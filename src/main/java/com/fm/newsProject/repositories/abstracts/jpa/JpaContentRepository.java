package com.fm.newsProject.repositories.abstracts.jpa;

import com.fm.newsProject.models.concretes.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaContentRepository extends JpaRepository<Content, Integer> {
}
