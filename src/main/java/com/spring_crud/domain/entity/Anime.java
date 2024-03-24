package com.spring_crud.domain.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_anime")
public class Anime implements Serializable {

    @Serial
    private static final long serialVersionUID = -696969L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama_anime;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @JoinTable(name = "s_category_anime", joinColumns = @JoinColumn(name = "anime_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "category_id", nullable = false))
    private List<Category> categories;
}
