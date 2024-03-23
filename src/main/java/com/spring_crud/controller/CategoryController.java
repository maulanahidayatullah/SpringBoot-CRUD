package com.spring_crud.controller;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.model.response.CategoryResponse;
import com.spring_crud.services.category.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Category Anime")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get All Category")
    public ResponseEntity<Page<CategoryResponse>> getAll(
            @ParameterObject Pageable pageable,
            @RequestParam(required = false) String search) {
        return new ResponseEntity<>(categoryService.getAll(pageable, search), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Detail Category")
    public BaseResponse<CategoryResponse> detail(@PathVariable String id) {
        return categoryService.detail(id);
    }
}
