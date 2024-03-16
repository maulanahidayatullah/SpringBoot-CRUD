package com.spring_crud.services.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_crud.domain.entity.User;
import com.spring_crud.domain.repository.UserRepository;
import com.spring_crud.model.dto.GetUserDto;
import com.spring_crud.model.request.UserRequestDto;
import com.spring_crud.model.response.BaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public Page<GetUserDto> getAll(Pageable pageable, String search) {
        Page<User> pgb = userRepository.getAll(pageable, search);

        List<GetUserDto> spluList = pgb.getContent()
                .stream()
                .map((user) -> GetUserDto.builder()
                        .name(user.getName())
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .toList();

        return new PageImpl<>(spluList, pgb.getPageable(), pgb.getTotalElements());
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
