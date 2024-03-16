package com.spring_crud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_crud.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
