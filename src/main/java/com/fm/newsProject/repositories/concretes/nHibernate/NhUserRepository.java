package com.fm.newsProject.repositories.concretes.nHibernate;

import com.fm.newsProject.core.entities.concretes.User;
import com.fm.newsProject.core.repository.nHibernate.NhModelRepositoryBase;
import com.fm.newsProject.repositories.abstracts.jpa.JpaUserRepository;
import com.fm.newsProject.repositories.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NhUserRepository extends NhModelRepositoryBase<User, JpaUserRepository> implements UserRepository {

    @Autowired
    public NhUserRepository(JpaUserRepository jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public User add(User entity) {
        entity.setActive(true);
        return super.add(entity);
    }
}
