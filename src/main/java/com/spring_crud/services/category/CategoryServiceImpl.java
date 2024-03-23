package com.spring_crud.services.category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring_crud.domain.entity.Category;
import com.spring_crud.domain.repository.CategoryRepository;
import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.model.response.CategoryResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository = null;

    @SuppressWarnings("null")
    @Override
    public Page<CategoryResponse> getAll(Pageable pageable, String search) {
        Page<Category> pgb = categoryRepository.getAll(pageable, search);

        List<CategoryResponse> categoryList = pgb.getContent()
                .stream()
                .map((category) -> CategoryResponse.builder()
                        .nama_category(category.getNama_category())
                        .build())
                .toList();

        return new PageImpl<>(categoryList, pgb.getPageable(), pgb.getTotalElements());
    }

    @Override
    public BaseResponse<CategoryResponse> detail(String id) {

        Optional<Category> data = categoryRepository.findById(Long.parseLong(id));

        if (!data.isPresent()) {
            return BaseResponse.error("Category Not Found");
        }

        Category category = data.get();

        CategoryResponse response = CategoryResponse.builder()
                .nama_category(category.getNama_category())
                .build();

        return BaseResponse.ok(response);
    }
}
