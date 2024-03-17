package com.spring_crud.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

import com.spring_crud.model.request.UserRequest;
import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.model.response.UserResponse;
import com.spring_crud.services.user.UserService;

import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @ParameterObject Pageable pageable,
            @RequestParam(required = false) String search) {
        return new ResponseEntity<>(userService.getAll(pageable, search), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public BaseResponse<List<UserResponse>> detail(@PathVariable String id) {
        return userService.detail(id);
    }

    @PostMapping
    public BaseResponse<String> save(@Valid @RequestBody UserRequest request, Errors errors) {
        if (errors.hasErrors()) {
            List<String> errorMessages = errors.getFieldErrors().stream()
                    .map(e -> e.getField() + ": " + e.getDefaultMessage())
                    .collect(Collectors.toList());

            return BaseResponse.validation(errorMessages);
        }
        return userService.save(request);
    }

}
