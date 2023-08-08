package com.example.pruebarestapi.security.service;

import com.example.pruebarestapi.model.AuthModel;
import com.example.pruebarestapi.repository.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;

    public CustomUserDetailsService(AuthRepository userRepository) {
        this.authRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        AuthModel authModel = authRepository.findByUser(user);
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        return User.builder()
                .username(authModel.getUser())
                .password(authModel.getPass())
                .roles(roles.toArray(new String[0]))
                .build();
    }
}
