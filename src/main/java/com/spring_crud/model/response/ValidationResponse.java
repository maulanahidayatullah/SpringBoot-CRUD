package com.spring_crud.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationResponse<T> extends BaseResponse<T> {
    @JsonIgnore
    private T data;
}