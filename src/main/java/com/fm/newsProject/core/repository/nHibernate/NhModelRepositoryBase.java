package com.fm.newsProject.core.repository.nHibernate;

import com.fm.newsProject.core.utilities.errors.EntityNotFoundError;
import com.fm.newsProject.core.entities.abstracts.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NhModelRepositoryBase<TEntity extends Entity, TJpaRepository extends JpaRepository<TEntity, Integer>> {

    private final TJpaRepository jpaRepository;

    public NhModelRepositoryBase(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") TJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public TEntity add(TEntity entity){
        return this.jpaRepository.save(entity);
    }

    public TEntity update(TEntity entity){
        return this.jpaRepository.save(entity);
    }

    public void delete(TEntity entity){
        this.jpaRepository.delete(entity);
    }

    public List<TEntity> getAll(){
        return this.jpaRepository.findAll();
    }

    public List<TEntity> getAll(Predicate<? super TEntity> filter){
        return this.jpaRepository.findAll().stream().filter(filter).collect(Collectors.toList());
    }

    public TEntity get(Predicate<? super TEntity> filter, String model){
        return this.jpaRepository.findAll().parallelStream().filter(filter).findFirst().orElseThrow(()-> new EntityNotFoundError(model, model + " Getirme",model + " Bulunamadı."));
    }
}