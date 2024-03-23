package com.spring_crud.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring_crud.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
        @Query("SELECT u FROM User u " +
                        "WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :search, '%')) OR :search IS NULL OR :search = ''")
        Page<User> getAll(
                        Pageable pageable,
                        String search);
}
