package com.spring_crud.services.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_crud.model.dto.GetUserDto;
import com.spring_crud.model.response.BaseResponse;

@Service
public interface UserService {

    BaseResponse<List<GetUserDto>> getAll();

    // Iterable<User> findall();

}