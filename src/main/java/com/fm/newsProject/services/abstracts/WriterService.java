package com.fm.newsProject.services.abstracts;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.models.concretes.Writer;

import java.util.List;

public interface WriterService {
    Result add(Writer writer);
    Result delete(Writer writer);
    Result update(Writer writer);
    DataResult<List<Writer>> getAll();
    DataResult<Writer> getById(int id);
}
