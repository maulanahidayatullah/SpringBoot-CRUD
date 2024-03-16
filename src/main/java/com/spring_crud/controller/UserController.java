package com.spring_crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

import com.spring_crud.model.dto.GetUserDto;
import com.spring_crud.services.user.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity<Page<GetUserDto>> getAll(
            @ParameterObject Pageable pageable,
            @RequestParam(required = false) String search) {
        return new ResponseEntity<>(userService.getAll(pageable, search), HttpStatus.OK);
    }
}
