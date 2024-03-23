package com.spring_crud.model.response;

import com.spring_crud.domain.entity.Category;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
@Data
public class AnimeResponse {
    private String nama_anime;
    private List<Category> categories;
}
