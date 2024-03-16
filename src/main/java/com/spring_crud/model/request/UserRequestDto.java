package com.spring_crud.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
public class UserRequestDto {

    @NotEmpty(message = "Email is required")
    @NotBlank(message = "Email is required")
    private String name;

    private String username;
    private String password;
}
