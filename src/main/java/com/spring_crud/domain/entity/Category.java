package com.spring_crud.domain.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_category")
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = -696969L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Kudu ada :v")
    @Column(length = 100, nullable = false)
    private String nama_category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "s_category_anime", joinColumns = @JoinColumn(name = "category_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "anime_id", nullable = false))
    private List<Anime> animes;
}
