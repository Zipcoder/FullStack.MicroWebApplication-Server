package com.theocho.youflix.services;


import com.theocho.youflix.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServices {

    @Autowired
    private ProfileRepository profileRepository;

}
