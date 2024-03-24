package com.spring_crud.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDto {

    private Long categoryId;
    private String namaCategory;

}
