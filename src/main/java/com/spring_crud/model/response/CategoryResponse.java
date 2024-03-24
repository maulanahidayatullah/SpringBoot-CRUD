package com.spring_crud.model.response;

import java.util.List;

import com.spring_crud.model.dto.AnimeDto;
import com.spring_crud.model.dto.CategoryDto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryResponse {
    private String nama_category;
    private List<AnimeDto> animes;
}
