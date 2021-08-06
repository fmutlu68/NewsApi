package com.fm.newsProject.services.abstracts;

import com.fm.newsProject.core.entities.concretes.User;
import com.fm.newsProject.core.entities.concretes.UserDtoForLogin;
import com.fm.newsProject.core.entities.concretes.UserDtoForRegister;
import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.core.utilities.security.jwt.AccessToken;

public interface AuthService {
    DataResult<AccessToken> register(UserDtoForRegister user);
    DataResult<AccessToken> login(UserDtoForLogin user);
    DataResult<AccessToken> createAccessToken(User user);
    Result userExists(String email);
    Result changePassword();

}
