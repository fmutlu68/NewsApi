package com.fm.newsProject.core.utilities.errors;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EnumNotFoundError extends RuntimeException{
    private String enumName;
    private final LocalDateTime failedAt;

    public EnumNotFoundError(String message, String enumName){
        super(message);
        this.enumName = enumName;
        this.failedAt = LocalDateTime.now();
    }
}
