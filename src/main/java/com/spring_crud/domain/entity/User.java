package com.spring_crud.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Kudu ada :v")
    private String name;

    @NotEmpty(message = "Kudu ada :v")
    @Column(unique = true)
    private String username;

    private String password;

    private String token;

    private String token_expired_at;

    @ManyToOne
    private Anime anime;
}
