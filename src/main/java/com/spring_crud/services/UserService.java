package com.spring_crud.services;

import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_crud.model.entity.User;
import com.spring_crud.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @SuppressWarnings("null")
    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    // @SuppressWarnings( "null" })
    @SuppressWarnings("null")
    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            return null;
        }
        return user.get();
    }

    @SuppressWarnings("null")
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}