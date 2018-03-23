package com.tree.boot.controller;

import com.tree.boot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("get")
    public User get(){
        User user = new User();
        user.setId(1);
        user.setName("Lucy");

        return user;
    }

}
