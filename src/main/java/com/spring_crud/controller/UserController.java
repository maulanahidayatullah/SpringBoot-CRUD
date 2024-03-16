package com.spring_crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.spring_crud.model.dto.GetUserDto;
import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.services.user.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // @PostMapping("/api/user")
    // public ResponseEntity<ResponseMapper<User>> create(@Valid @RequestBody
    // UserRequestDto userRequestDto,
    // Errors errors) {

    // ResponseMapper<User> responseData = new ResponseMapper<>();

    // if (errors.hasErrors()) {
    // for (ObjectError objectError : errors.getAllErrors()) {
    // responseData.getMessages().add(objectError.getDefaultMessage());
    // }
    // responseData.setStatus(false);
    // responseData.setPayload(null);
    // return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
    // }

    // responseData.getMessages().add("Berhasil Menambahkan User");
    // responseData.setStatus(true);
    // responseData.setPayload(null);
    // // userService.save(user);
    // return new ResponseEntity<>(responseData, HttpStatus.OK);
    // }

    @GetMapping("/api/user")
    public BaseResponse<List<GetUserDto>> getAll() {
        return userService.getAll();
    }

    // @GetMapping("/api/user/{id}")
    // public User getById(@PathVariable("id") Long id) {
    // return userService.getById(id);
    // }

    // @PutMapping("/api/user")
    // public User update(@RequestBody User user) {
    // return userService.save(user);
    // }
}
