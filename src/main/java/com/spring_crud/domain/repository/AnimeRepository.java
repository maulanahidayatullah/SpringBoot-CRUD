package com.spring_crud.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring_crud.domain.entity.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

        @Query("SELECT DISTINCT a FROM Anime a " +
                        "WHERE LOWER(a.nama_anime) LIKE LOWER(CONCAT('%', :search, '%')) ")
        Page<Anime> getAll(
                        Pageable pageable,
                        String search);
}
