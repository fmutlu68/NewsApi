package com.fm.newsProject.models.dtos;

import com.fm.newsProject.models.concretes.News;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDtoToAdd {
    private MultipartFile image;
    private News news;
}
