package com.spring_crud.services.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.model.response.CategoryResponse;

@Service
public interface CategoryService {

    Page<CategoryResponse> getAll(Pageable pageable, String search);

    BaseResponse<CategoryResponse> detail(String id);

    // BaseResponse<String> save(UserRequest request);

}
