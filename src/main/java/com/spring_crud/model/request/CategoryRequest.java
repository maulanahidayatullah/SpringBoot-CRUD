package com.spring_crud.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    @NotEmpty(message = "Kudu ada :v")
    private String nama_category;

}
