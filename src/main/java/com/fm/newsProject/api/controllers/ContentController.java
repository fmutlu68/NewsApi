package com.fm.newsProject.api.controllers;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.models.concretes.Content;
import com.fm.newsProject.services.abstracts.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin(origins = "http://localhost:4200")
public class ContentController {
    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/getall")
    public DataResult<List<Content>> getAll(){
        return this.contentService.getAll();
    }
}
