package com.fm.newsProject.core.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoForRegister {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String username;
}
