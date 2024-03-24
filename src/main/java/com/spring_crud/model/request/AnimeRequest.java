package com.spring_crud.model.request;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimeRequest {

    @NotEmpty(message = "Kudu ada :v")
    private String nama_anime;

    private List<Long> categoryId;
}
