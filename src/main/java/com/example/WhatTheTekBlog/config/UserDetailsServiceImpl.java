package com.example.WhatTheTekBlog.config;

import com.example.WhatTheTekBlog.models.AppUser;
import com.example.WhatTheTekBlog.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByName(name);
        if (appUser == null) {
            throw new UsernameNotFoundException(name);
        }
        return new User(appUser.getName(), appUser.getPassword(), emptyList());
    }
}
