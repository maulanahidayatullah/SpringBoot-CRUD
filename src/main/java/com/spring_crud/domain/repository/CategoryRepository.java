package com.spring_crud.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring_crud.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
        @Query("SELECT DISTINCT c FROM Category c " +
                        "WHERE LOWER(c.nama_category) LIKE LOWER(CONCAT('%', :search, '%')) ")
        Page<Category> getAll(
                        Pageable pageable,
                        String search);
}
