package com.spring_crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

import com.spring_crud.model.request.UserRequest;
import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.model.response.UserResponse;
import com.spring_crud.services.user.UserService;

import org.springdoc.core.annotations.ParameterObject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get All User")
    public ResponseEntity<Page<UserResponse>> getAll(
            @ParameterObject Pageable pageable,
            @RequestParam(required = false) String search) {
        return new ResponseEntity<>(userService.getAll(pageable, search), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Detail User")
    public BaseResponse<UserResponse> detail(@PathVariable String id) {
        return userService.detail(id);
    }

    @PostMapping
    @Operation(summary = "Create User")
    public BaseResponse<String> save(@Valid @RequestBody UserRequest request) {
        return userService.save(request);
    }

}
