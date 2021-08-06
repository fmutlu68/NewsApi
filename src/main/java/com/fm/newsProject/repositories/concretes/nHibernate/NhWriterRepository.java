package com.fm.newsProject.repositories.concretes.nHibernate;

import com.fm.newsProject.core.repository.nHibernate.NhModelRepositoryBase;
import com.fm.newsProject.models.concretes.Writer;
import com.fm.newsProject.repositories.abstracts.jpa.JpaWriterRepository;
import com.fm.newsProject.repositories.abstracts.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NhWriterRepository extends NhModelRepositoryBase<Writer, JpaWriterRepository> implements WriterRepository {

    @Autowired
    public NhWriterRepository(JpaWriterRepository jpaRepository) {
        super(jpaRepository);
    }
}
