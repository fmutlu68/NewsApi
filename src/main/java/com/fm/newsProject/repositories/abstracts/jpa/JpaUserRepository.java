package com.fm.newsProject.repositories.abstracts.jpa;

import com.fm.newsProject.core.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Integer> {
}
