package com.fm.newsProject.services.concretes;

import com.fm.newsProject.core.utilities.results.*;
import com.fm.newsProject.models.concretes.Content;
import com.fm.newsProject.repositories.abstracts.jpa.JpaContentRepository;
import com.fm.newsProject.services.abstracts.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentManager implements ContentService {
    private final JpaContentRepository contentRepository;

    @Autowired
    public ContentManager(JpaContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public Result add(Content content) {
        this.contentRepository.save(content);
        return new SuccessResult("İçerik Eklendi.");
    }

    @Override
    public Result delete(Content content) {
        this.contentRepository.delete(content);
        return new SuccessResult("İçerik Silindi.");
    }

    @Override
    public Result update(Content content) {
        Content contentToUpdate = this.contentRepository.findById(content.getId()).orElse(null);
        if (contentToUpdate == null){
            return new ErrorResult("İçerik Bulunamadı.");
        }
        contentToUpdate = content;
        return new SuccessResult("İçerik Güncellendi.");
    }

    @Override
    public DataResult<List<Content>> getAll() {
        return new SuccessDataResult<List<Content>>(this.contentRepository.findAll(), "İçerikler Listelendi.");
    }
}
