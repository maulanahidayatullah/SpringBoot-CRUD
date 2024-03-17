package com.spring_crud.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {

    private String name;
    private String username;
    private String password;
}
