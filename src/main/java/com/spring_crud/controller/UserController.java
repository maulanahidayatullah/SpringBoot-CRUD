package com.spring_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.spring_crud.model.entity.User;
import com.spring_crud.services.UserService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/api/user")
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/api/user/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PutMapping("/api/user")
    public User update(@RequestBody User user) {
        return userService.save(user);
    }
}
