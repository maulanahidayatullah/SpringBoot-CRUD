package com.spring_crud.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {

    private String name;
    private String username;
    private String password;
}
