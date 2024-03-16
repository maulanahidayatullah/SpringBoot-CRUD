package com.spring_crud.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Kudu ada :v")
    @Column(length = 100, nullable = false)
    private String name;

    @NotEmpty(message = "Kudu ada :v")
    @Column(length = 100, nullable = false)
    private String rilis;
}
