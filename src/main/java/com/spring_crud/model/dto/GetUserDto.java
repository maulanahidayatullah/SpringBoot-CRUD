package com.spring_crud.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetUserDto {

    private String name;
    private String username;
    private String password;
}
