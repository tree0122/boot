package com.tree.boot.security.service;

import com.google.common.collect.Lists;
import com.tree.boot.security.config.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getByUsername(String username) {
        return User
                .builder()
                .id(10)
                .password(username)
                .userName(username)
                .roles(Lists.newArrayList("ROLE_ADMIN", "ROLE_GUEST"))
                .build();
    }
}
