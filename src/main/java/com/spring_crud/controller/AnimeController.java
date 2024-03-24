package com.spring_crud.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_crud.model.request.AnimeRequest;
import com.spring_crud.model.response.AnimeResponse;
import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.services.anime.AnimeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Anime")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/anime")
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping
    @Operation(summary = "Get All Anime")
    public ResponseEntity<Page<AnimeResponse>> getAll(
            @ParameterObject Pageable pageable,
            @RequestParam(required = false) String search) {
        return new ResponseEntity<>(animeService.getAll(pageable, search), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Detail Anime")
    public BaseResponse<AnimeResponse> detail(@PathVariable String id) {
        return animeService.detail(id);
    }

    @Operation(summary = "Create Anime")
    @PostMapping
    public BaseResponse<String> save(@Valid @RequestBody AnimeRequest request) {
        return animeService.save(request);
    }
}
