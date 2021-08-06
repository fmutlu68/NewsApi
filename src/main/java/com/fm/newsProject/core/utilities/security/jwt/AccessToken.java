package com.fm.newsProject.core.utilities.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {
    private String token;
    private Date expiration;
}
