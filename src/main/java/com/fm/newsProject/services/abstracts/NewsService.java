package com.fm.newsProject.services.abstracts;

import java.util.List;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.models.concretes.News;

public interface NewsService {
	Result add(News news);
	Result delete(News news);
	Result deleteById(int id);
	Result update(News news);
	DataResult<List<News>> getAll();
	DataResult<List<News>> getAllByCategoryId(int categoryId);
	DataResult<News> getById(int id);
}
