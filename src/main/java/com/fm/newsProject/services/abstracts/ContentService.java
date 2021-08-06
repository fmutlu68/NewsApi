package com.fm.newsProject.services.abstracts;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.models.concretes.Content;

import java.util.List;

public interface ContentService {
    Result add(Content content);
    Result delete(Content content);
    Result update(Content content);
    DataResult<List<Content>> getAll();
}
