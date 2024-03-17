package com.spring_crud.model.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotEmpty
    @Length(max = 50)
    private String name;

    @NotEmpty
    @Length(max = 50)
    private String username;

    @NotEmpty
    @Length(max = 50)
    private String password;

}
