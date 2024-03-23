package com.spring_crud.services.anime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring_crud.model.request.AnimeRequest;
import com.spring_crud.model.response.AnimeResponse;
import com.spring_crud.model.response.BaseResponse;

@Service
public interface AnimeService {

    Page<AnimeResponse> getAll(Pageable pageable, String search);

    BaseResponse<AnimeResponse> detail(String id);

    BaseResponse<String> save(AnimeRequest request);

}
