package com.spring_crud.services.anime;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring_crud.domain.entity.Anime;
import com.spring_crud.domain.repository.AnimeRepository;
import com.spring_crud.exception.CustomException;
import com.spring_crud.model.request.AnimeRequest;
import com.spring_crud.model.response.AnimeResponse;
import com.spring_crud.model.response.BaseResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepository animeRepository;

    @Override
    public Page<AnimeResponse> getAll(Pageable pageable, String search) {
        Page<Anime> pgb = animeRepository.getAll(pageable, search);

        List<AnimeResponse> animeList = pgb.getContent()
                .stream()
                .map((anime) -> AnimeResponse.builder()
                        .nama_anime(anime.getNama_anime())
                        .build())
                .toList();

        return new PageImpl<>(animeList, pgb.getPageable(), pgb.getTotalElements());
    }

    @Override
    public BaseResponse<AnimeResponse> detail(String id) {

        Optional<Anime> data = animeRepository.findById(Long.parseLong(id));

        if (!data.isPresent()) {
            return BaseResponse.error("User Not Found");
        }

        Anime anime = data.get();

        AnimeResponse response = AnimeResponse.builder()
                .nama_anime(anime.getNama_anime())
                .categories(anime.getCategories())
                .build();

        return BaseResponse.ok(response);
    }

    @Override
    public BaseResponse<String> save(AnimeRequest request) {

        Anime anime = new Anime();
        anime.setNama_anime(request.getNama_anime());
        anime.setCategories(request.getCategories());

        try {
            animeRepository.save(anime);
            return BaseResponse.ok("Success Save Data");
        } catch (RuntimeException exception) {
            throw new CustomException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
