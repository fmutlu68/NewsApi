package com.fm.newsProject.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptionDetail {
    private String urlPath;
    private String errorName;
    private LocalDateTime failedAt;
    private String errorMessage;
}
