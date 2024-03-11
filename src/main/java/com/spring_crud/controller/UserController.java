package com.spring_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.spring_crud.model.entity.User;
import com.spring_crud.services.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user")
    public Iterable<User> findAll() {
        return userService.findAll();
    }
}
