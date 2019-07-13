package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    
}
