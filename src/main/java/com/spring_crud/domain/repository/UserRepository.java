package com.spring_crud.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring_crud.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT DISTINCT u FROM User u " +
            "WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :search, '%')) ")
    Page<User> getAll(
            Pageable pageable,
            String search);
}
