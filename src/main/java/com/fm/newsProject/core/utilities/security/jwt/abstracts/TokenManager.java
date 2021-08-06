package com.fm.newsProject.core.utilities.security.jwt.abstracts;

import com.fm.newsProject.core.entities.concretes.User;
import com.fm.newsProject.core.utilities.security.jwt.AccessToken;

public interface TokenManager {
    AccessToken createToken(User user);
    boolean tokenValidate(String token);
    String getUserFromToken(String token);
}
