package com.spring_crud.services.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_crud.model.dto.GetUserDto;
import com.spring_crud.model.response.BaseResponse;

@Service
public interface UserService {

    Page<GetUserDto> getAll(Pageable p, String search);

    // Iterable<User> findall();

}