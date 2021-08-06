package com.fm.newsProject.services.concretes;

import com.fm.newsProject.core.entities.concretes.User;
import com.fm.newsProject.core.entities.concretes.UserDtoForLogin;
import com.fm.newsProject.core.entities.concretes.UserDtoForRegister;
import com.fm.newsProject.core.utilities.results.*;
import com.fm.newsProject.core.utilities.security.hashing.HashingManager;
import com.fm.newsProject.core.utilities.security.jwt.AccessToken;
import com.fm.newsProject.core.utilities.security.jwt.abstracts.TokenManager;
import com.fm.newsProject.services.abstracts.AuthService;
import com.fm.newsProject.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private final UserService userService;
    private final TokenManager tokenManager;
    private final HashingManager hashingManager;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthManager(UserService userService, TokenManager tokenManager, HashingManager hashingManager, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenManager = tokenManager;
        this.hashingManager = hashingManager;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public DataResult<AccessToken> register(UserDtoForRegister user) {
        var userIsRegistered = userService.getByUsername(user.getUsername());
        if (userIsRegistered.isSuccess()){
            return new ErrorDataResult<>("Kullanıcı Adı Önceden Alınmış.");
        }
        if (userExists(user.getEmail()).isSuccess()){
            return new ErrorDataResult<>("Email Adresiyle Önceden Kayıt Olunmuş.");
        }
        String hashedPassword = hashingManager.createPasswordWithHashing(user.getPassword());
        User userToRegister = new User(user.getFirstname(), user.getLastname(), user.getEmail(), hashedPassword, user.getUsername());
        Result resultForRegister = this.userService.add(userToRegister);
        if (resultForRegister.isSuccess()){
            var token = createAccessToken(userToRegister).getData();
            return new SuccessDataResult<>(token,"Kayıt İşlemi Başarılı.");
        }
        return new ErrorDataResult<>("Kayıt Başarısız.");
    }

    @Override
    public DataResult<AccessToken> login(UserDtoForLogin user) {
        var userToCheck = userService.getByUsername(user.getUsername());
        if (userToCheck.getData() == null){
            return new ErrorDataResult<>("Girilen Bilgileri Kontrol Ediniz.");
        }
        if (!hashingManager.verifyPasswordHash(userToCheck.getData().getPassword(), user.getPassword())){
            return new ErrorDataResult<>("Girilen Bilgileri Kontrol Ediniz.");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userToCheck.getData().getUsername(), user.getPassword()));
        var token = createAccessToken(userToCheck.getData()).getData();
        return new SuccessDataResult<>(token, "Giriş Başarılı");
    }

    @Override
    public DataResult<AccessToken> createAccessToken(User user) {
        return new SuccessDataResult<>(tokenManager.createToken(user));
    }

    @Override
    public Result userExists(String email) {
        var result = userService.getByEmail(email);
        if (result.isSuccess()){
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    @Override
    public Result changePassword() {
        return null;
    }
}
