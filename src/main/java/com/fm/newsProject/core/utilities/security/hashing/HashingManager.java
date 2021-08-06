package com.fm.newsProject.core.utilities.security.hashing;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashingManager {
    private BCryptPasswordEncoder jPasswordEncoder = new BCryptPasswordEncoder();;

    public String createPasswordWithHashing(String password) {
        System.out.println("Password:" + password);
        return jPasswordEncoder.encode(password);
    }

    public boolean verifyPasswordHash(String realPassword, String password){
        var specifiedHashedPassword = jPasswordEncoder.encode(password);
        var result = BCrypt.checkpw(password, realPassword);
        return result;
    }
}
