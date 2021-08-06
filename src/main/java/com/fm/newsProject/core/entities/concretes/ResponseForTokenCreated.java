package com.fm.newsProject.core.entities.concretes;

import com.fm.newsProject.core.utilities.security.jwt.AccessToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseForTokenCreated {
    private User user;
    private AccessToken token;
}
