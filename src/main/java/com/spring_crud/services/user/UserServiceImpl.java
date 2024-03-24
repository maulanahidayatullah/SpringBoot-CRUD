package com.spring_crud.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring_crud.domain.entity.User;
import com.spring_crud.domain.repository.UserRepository;
import com.spring_crud.exception.CustomException;
import com.spring_crud.model.request.UserRequest;
import com.spring_crud.model.response.BaseResponse;
import com.spring_crud.model.response.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public Page<UserResponse> getAll(Pageable pageable, String search) {
        Page<User> pgb = userRepository.getAll(pageable, search);

        List<UserResponse> userList = pgb.getContent()
                .stream()
                .map((user) -> UserResponse.builder()
                        .name(user.getName())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .toList();

        return new PageImpl<>(userList, pgb.getPageable(), pgb.getTotalElements());
    }

    @Override
    public BaseResponse<UserResponse> detail(String id) {

        Optional<User> data = userRepository.findById(Long.parseLong(id));

        if (!data.isPresent()) {
            return BaseResponse.error("User Not Found");
        }

        User user = data.get();

        UserResponse response = UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        return BaseResponse.ok(response);
    }

    @Override
    public BaseResponse<String> save(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        try {
            userRepository.save(user);
            return BaseResponse.ok("Success Save Data");
        } catch (RuntimeException exception) {
            throw new CustomException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // public User save(User user) {
    // return userRepository.save(user);
    // }

    // @Override
    // Iterable<User> findAll() {
    // return userRepository.findAll();
    // }

    // @SuppressWarnings("null")
    // public User getById(Long id) {
    // Optional<User> user = userRepository.findById(id);

    // if (!user.isPresent()) {
    // return null;
    // }
    // return user.get();
    // }

    // @SuppressWarnings("null")
    // public void delete(Long id) {
    // userRepository.deleteById(id);
    // }

}
