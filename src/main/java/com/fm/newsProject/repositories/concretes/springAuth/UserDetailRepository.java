package com.fm.newsProject.repositories.concretes.springAuth;

import com.fm.newsProject.repositories.abstracts.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailRepository implements UserDetailsService {

    private final JpaUserRepository userRepository;

    @Autowired
    public UserDetailRepository(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findAll().parallelStream()
                .filter(u-> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(()->new UsernameNotFoundException(username));
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
