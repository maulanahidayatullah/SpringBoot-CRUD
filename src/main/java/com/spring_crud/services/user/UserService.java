package com.spring_crud.services.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring_crud.model.request.UserRequest;
import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.model.response.UserResponse;

@Service
public interface UserService {

    Page<UserResponse> getAll(Pageable pageable, String search);

    BaseResponse<UserResponse> detail(String id);

    BaseResponse<String> save(UserRequest request);

}