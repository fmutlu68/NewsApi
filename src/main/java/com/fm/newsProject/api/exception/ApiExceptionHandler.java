package com.fm.newsProject.api.exception;

import com.fm.newsProject.core.utilities.errors.EntityNotFoundError;
import com.fm.newsProject.core.utilities.errors.EnumNotFoundError;
import com.fm.newsProject.core.utilities.errors.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Component
public class ApiExceptionHandler {

    @ExceptionHandler({ValidationError.class})
    public ResponseEntity validationError(ValidationError error, WebRequest request){
        ApiExceptionDetail exceptionDetail = new ApiExceptionDetail(request.getDescription(false).split("=")[1], "Doğrulama Hatası", error.getFailedTime(),error.getErrorMessage());
        return new ResponseEntity(exceptionDetail, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({EntityNotFoundError.class})
    public ResponseEntity entityNotFoundError(EntityNotFoundError error, WebRequest request){
        ApiExceptionDetail exceptionDetail = new ApiExceptionDetail(request.getDescription(false).split("=")[1], "Nesne Bulunamadı Hatası", error.getFailedAt(), error.getErrorMessage());
        return new ResponseEntity(exceptionDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EnumNotFoundError.class})
    public ResponseEntity enumNotFoundError(EnumNotFoundError error, WebRequest request){
        ApiExceptionDetail exceptionDetail = new ApiExceptionDetail(request.getDescription(false).split("=")[1], "Enum Bulunamadı Hatası", error.getFailedAt(), error.getMessage());
        return new ResponseEntity(exceptionDetail, HttpStatus.NOT_FOUND);
    }
}
