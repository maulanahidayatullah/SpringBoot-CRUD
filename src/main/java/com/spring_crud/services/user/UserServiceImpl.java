package com.spring_crud.services.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_crud.domain.entity.User;
import com.spring_crud.domain.repository.UserRepository;
import com.spring_crud.model.dto.GetUserDto;
import com.spring_crud.model.response.BaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public BaseResponse<List<GetUserDto>> getAll() {
        List<User> pgb = userRepository.findAll();

        List<GetUserDto> userList = pgb
                .stream()
                .map((user) -> GetUserDto.builder()
                        .name(user.getName())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .toList();

        return BaseResponse.ok(userList);
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
