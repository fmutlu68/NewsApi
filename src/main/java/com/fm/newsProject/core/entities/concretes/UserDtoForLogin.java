package com.fm.newsProject.core.entities.concretes;

import com.fm.newsProject.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoForLogin implements Dto {
    private String username;
    private String password;
}
