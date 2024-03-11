package com.spring_crud.services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_crud.model.entity.User;
import com.spring_crud.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}