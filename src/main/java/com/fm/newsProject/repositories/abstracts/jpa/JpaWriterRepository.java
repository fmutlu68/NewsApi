package com.fm.newsProject.repositories.abstracts.jpa;

import com.fm.newsProject.models.concretes.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JpaWriterRepository extends JpaRepository<Writer, Integer> {
}
