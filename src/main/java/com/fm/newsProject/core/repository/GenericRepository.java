package com.fm.newsProject.core.repository;

import java.util.List;
import java.util.function.Predicate;

public interface GenericRepository<T> {
	T add(T entity);
	T update(T entity);
	void delete(T entity);
	List<T> getAll();
	List<T> getAll(Predicate<? super T> filter);
	T get(Predicate<? super T> filter, String model);
}
