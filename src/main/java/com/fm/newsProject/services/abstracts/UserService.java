package com.fm.newsProject.services.abstracts;

import com.fm.newsProject.core.entities.concretes.User;
import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;

import java.util.List;

public interface UserService {
    Result add(User user);
    Result delete(User user);
    Result update(User user);
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
    DataResult<User> getByUsername(String username);
    DataResult<User> getByEmail(String email);
}
