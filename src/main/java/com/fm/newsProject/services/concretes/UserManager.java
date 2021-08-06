package com.fm.newsProject.services.concretes;

import com.fm.newsProject.core.entities.concretes.User;
import com.fm.newsProject.core.utilities.errors.EntityNotFoundError;
import com.fm.newsProject.core.utilities.results.*;
import com.fm.newsProject.repositories.abstracts.UserRepository;
import com.fm.newsProject.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result add(User user) {
        this.userRepository.add(user);
        return new SuccessResult("Kullanıcı Eklendi.");
    }

    @Override
    public Result delete(User user) {
        this.userRepository.delete(user);
        return new SuccessResult("Kullanıcı Silindi.");
    }

    @Override
    public Result update(User user) {
        this.userRepository.update(user);
        return new SuccessResult("Kullanıcı Güncellendi.");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.getAll());
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(this.userRepository.get(user -> user.getId() == id, "Kullanıcı"));
    }

    @Override
    public DataResult<User> getByUsername(String username) {
        try {
            return new SuccessDataResult<User>(this.userRepository.get(user -> user.getUsername().equals(username), "Kullanıcı"));
        }catch (EntityNotFoundError error){
            return new ErrorDataResult<User>("Kullanıcı Bulunamadı");
        }
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        try {
            return new SuccessDataResult<User>(this.userRepository.get(user -> user.getEmail().equals(email), "Kullanıcı"));
        }catch (EntityNotFoundError error){
            return new ErrorDataResult<User>("Kullanıcı Bulunamadı");
        }
    }
}
