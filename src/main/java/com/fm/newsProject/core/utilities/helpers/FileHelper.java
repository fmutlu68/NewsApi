package com.fm.newsProject.core.utilities.helpers;


import com.fm.newsProject.core.entities.abstracts.Helper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper implements Helper {

    @Value("${app.}")
    public String uploadDirectory;

    public String saveFile(MultipartFile file){
        Path imgPath = Paths.get();
    }
}
